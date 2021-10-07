package exam;

import java.math.BigDecimal;

/**
 * 変動金利。
 */
public interface FloatingInterestRate extends InterestRate {
    void addRate(RepaymentMonth month, BigDecimal rate);
}
