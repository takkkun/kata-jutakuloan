package exam.impl;

import exam.RepaymentMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;

class PrincipalEqualRepaymentMethod implements RepaymentMethod {

    private final BigDecimal amountOfMoneyBorrowed;

    private final Integer numberOfRepayments;

    private final Integer times;

    PrincipalEqualRepaymentMethod(final BigDecimal amountOfMoneyBorrowed, final Integer numberOfRepayments, final Integer times) {
        this.amountOfMoneyBorrowed = amountOfMoneyBorrowed;
        this.numberOfRepayments = numberOfRepayments;
        this.times = times;
    }

    @Override
    public BigDecimal calcAmountOfPrincipalRepayment(final BigDecimal interestRatePerMonth, final BigDecimal balance) {
        if (times >= numberOfRepayments) {
            return balance;
        }

        return amountOfMoneyBorrowed.divide(BigDecimal.valueOf(numberOfRepayments), 0, RoundingMode.UP);
    }

    @Override
    public BigDecimal calcAmountOfInterestRepayment(final BigDecimal interestRatePerMonth, final BigDecimal balance) {
        return balance.multiply(interestRatePerMonth).setScale(0, RoundingMode.UP);
    }
}
