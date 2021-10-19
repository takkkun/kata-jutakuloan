package exam.impl;

import exam.FixedInterestRate;
import exam.FloatingInterestRate;
import exam.RepaymentMonth;

import java.math.BigDecimal;

class LimitedFixedInterestRate implements FixedInterestRate {

    private final BigDecimal rate;

    private final int term;

    private final FloatingInterestRate interestRateAfterFixed;

    LimitedFixedInterestRate(final BigDecimal rate, final int term, final FloatingInterestRate interestRateAfterFixed) {
        this.rate = rate;
        this.term = term;
        this.interestRateAfterFixed = interestRateAfterFixed;
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month, final RepaymentMonth startMonth) {
        if (startMonth.elapsedYears(month) < term) {
            return getRate(month);
        } else {
            return interestRateAfterFixed.getRate(month, startMonth);
        }
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month) {
        return rate;
    }
}
