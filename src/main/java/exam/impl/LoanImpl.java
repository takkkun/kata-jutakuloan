package exam.impl;

import exam.Loan;
import exam.LoanCondition;
import exam.RepaymentMonth;
import exam.RepaymentPerMonth;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

public class LoanImpl implements Loan {

    private final LoanCondition condition;

    public LoanImpl(final LoanCondition condition) {
        this.condition = condition;
    }

    @Override
    public Stream<RepaymentPerMonth> repaymentStream(final RepaymentMonth startMonth) {
        final var seed = seed(condition.getAmountOfMoneyBorrowed(), startMonth);
        return Stream
            .iterate(seed, currentRepaymentPerMonth -> next(condition, startMonth, currentRepaymentPerMonth))
            .skip(1) // seedが含まれるので捨てる
            .limit(condition.getNumberOfRepayments());
    }

    private RepaymentPerMonth seed(final BigDecimal amountOfMoneyBorrowed, final RepaymentMonth startMonth) {
        return new RepaymentPerMonth(0, startMonth.plusMonths(-1), BigDecimal.ZERO, BigDecimal.ZERO, amountOfMoneyBorrowed);
    }

    private RepaymentPerMonth next(final LoanCondition condition, final RepaymentMonth startMonth, final RepaymentPerMonth currentRepaymentPerMonth) {
        final var nextTimes = currentRepaymentPerMonth.getTimes() + 1;
        final var nextRepaymentMonth = currentRepaymentPerMonth.getMonth().nextMonth();
        final var balance = currentRepaymentPerMonth.getBalance();

        final var repaymentMethodFactory = new RepaymentMethodFactoryImpl(condition.getRepaymentMethod(), nextTimes);
        final var repaymentMethod = repaymentMethodFactory.apply(condition.getAmountOfMoneyBorrowed(), condition.getNumberOfRepayments());

        final var interestRate = condition.getInterestRate().getRate(nextRepaymentMonth, startMonth);
        final var interestRatePerMonth = interestRate.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);

        final var amountOfPrincipalRepayment = repaymentMethod.calcAmountOfPrincipalRepayment(interestRatePerMonth, balance);
        final var amountOfInterestRepayment = repaymentMethod.calcAmountOfInterestRepayment(interestRatePerMonth, balance);
        final var nextBalance = balance.subtract(amountOfPrincipalRepayment);

        return new RepaymentPerMonth(nextTimes, nextRepaymentMonth, amountOfPrincipalRepayment, amountOfInterestRepayment, nextBalance);
    }
}
