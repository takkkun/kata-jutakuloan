package exam.impl;

import exam.RepaymentMethod;
import exam.RepaymentMethodFactory;
import exam.RepaymentMethodType;

import java.math.BigDecimal;

public class RepaymentMethodFactoryImpl implements RepaymentMethodFactory {

    private final RepaymentMethodType repaymentMethodType;

    private final Integer times;

    public RepaymentMethodFactoryImpl(final RepaymentMethodType repaymentMethodType, final Integer times) {
        this.repaymentMethodType = repaymentMethodType;
        this.times = times;
    }

    @Override
    public RepaymentMethod apply(final BigDecimal amountOfMoneyBorrowed, final Integer numberOfRepayments) {
        switch (repaymentMethodType) {
            case PRINCIPAL_AND_INTEREST_EQUAL:
                return new PrincipalAndInterestEqualRepaymentMethod(amountOfMoneyBorrowed, numberOfRepayments, times);
            case PRINCIPAL_EQUAL_MONTHLY:
                return new PrincipalEqualRepaymentMethod(amountOfMoneyBorrowed, numberOfRepayments, times);
            default:
                throw new IllegalStateException(String.format("unsupported RepaymentMethodType: %s", repaymentMethodType));
        }
    }
}
