package exam;

import java.math.BigDecimal;

public interface InterestRateFactory {
    FixedInterestRate createFixedInterestRate(BigDecimal rate);
    FixedInterestRate createLimitedFixedInterestRate(BigDecimal rate, int term, FloatingInterestRate interestRateAfterFixed);
    FloatingInterestRate createFloatingInterestRate(BigDecimal rate);
}
