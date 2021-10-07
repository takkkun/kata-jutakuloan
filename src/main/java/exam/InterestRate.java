package exam;

import java.math.BigDecimal;

/**
 * 金利を表す。
 */
public interface InterestRate {
    /**
     * 返済年月を元に金利を返す。
     *
     * @param month 返済年月
     * @param startMonth 返済開始年月
     * @return 金利 (年利のパーセンテージ)
     */
    BigDecimal getRate(RepaymentMonth month, RepaymentMonth startMonth);
    BigDecimal getRate(RepaymentMonth month);
}
