package exam.impl;

import exam.FixedInterestRate;
import exam.RepaymentMonth;

import java.math.BigDecimal;

class UnlimitedFixedInterestRate implements FixedInterestRate {

    private final BigDecimal rate;

    UnlimitedFixedInterestRate(final BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month, final RepaymentMonth startMonth) {
        return getRate(month);
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month) {
        return rate;
    }
}
