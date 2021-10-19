package exam.impl;

import exam.FixedInterestRate;
import exam.FloatingInterestRate;
import exam.InterestRateFactory;

import java.math.BigDecimal;

public class InterestRateFactoryImpl implements InterestRateFactory {

    @Override
    public FixedInterestRate createFixedInterestRate(final BigDecimal rate) {
        return new UnlimitedFixedInterestRate(rate);
    }

    @Override
    public FixedInterestRate createLimitedFixedInterestRate(final BigDecimal rate, final int term, final FloatingInterestRate interestRateAfterFixed) {
        return new LimitedFixedInterestRate(rate, term, interestRateAfterFixed);
    }

    @Override
    public FloatingInterestRate createFloatingInterestRate(final BigDecimal rate) {
        return new FloatingInterestRateImpl(rate);
    }
}
