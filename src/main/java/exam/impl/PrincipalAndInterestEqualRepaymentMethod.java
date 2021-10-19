package exam.impl;

import exam.RepaymentMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrincipalAndInterestEqualRepaymentMethod implements RepaymentMethod {

    private final BigDecimal amountOfMoneyBorrowed;

    private final Integer numberOfRepayments;

    private final Integer times;

    public PrincipalAndInterestEqualRepaymentMethod(final BigDecimal amountOfMoneyBorrowed, final Integer numberOfRepayments, final Integer times) {
        this.amountOfMoneyBorrowed = amountOfMoneyBorrowed;
        this.numberOfRepayments = numberOfRepayments;
        this.times = times;
    }

    @Override
    public BigDecimal calcAmountOfPrincipalRepayment(final BigDecimal interestRatePerMonth, final BigDecimal balance) {
        // 最後の返済で帳尻を合わせる必要があるため、「今の返済が総返済回数以降の場合」という条件を加えている。
        // ので、「何回目の返済か」変わるたびにRepaymentMethodを生成し直す必要がある。返済方法は変わらないので違和感はある……。
        if (times >= numberOfRepayments) {
            return balance;
        }

        final var compoundInterest = BigDecimal.ONE.add(interestRatePerMonth).pow(numberOfRepayments);
        final var numerator = amountOfMoneyBorrowed.multiply(interestRatePerMonth).multiply(compoundInterest);
        final var denominator = compoundInterest.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, 0, RoundingMode.UP).subtract(calcAmountOfInterestRepayment(interestRatePerMonth, balance));
    }

    @Override
    public BigDecimal calcAmountOfInterestRepayment(final BigDecimal interestRatePerMonth, final BigDecimal balance) {
        return balance.multiply(interestRatePerMonth).setScale(0, RoundingMode.UP);
    }
}
