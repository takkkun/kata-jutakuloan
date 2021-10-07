package exam;

import java.io.Serializable;
import java.math.BigDecimal;

public class RepaymentPerMonth implements Serializable {
    /** 返済回数(何回目か?) */
    private final int times;

    /** 返済年月 */
    private final RepaymentMonth month;

    /** 元金返済額 */
    private final BigDecimal principal;

    /** 利息返済額 */
    private final BigDecimal interest;

    /** ローン残高 */
    private final BigDecimal balance;

    public RepaymentPerMonth(int times, RepaymentMonth month, BigDecimal principal, BigDecimal interest, BigDecimal balance) {
        this.times = times;
        this.month = month;
        this.principal = principal;
        this.interest = interest;
        this.balance = balance;
    }

    public int getTimes() {
        return times;
    }

    public RepaymentMonth getMonth() {
        return month;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return times + " " + month + " " + principal + " " + interest + " " + balance;
    }

}
