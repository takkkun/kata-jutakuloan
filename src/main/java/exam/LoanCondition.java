package exam;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanCondition implements Serializable {
    private final BigDecimal amountOfMoneyBorrowed;
    private final InterestRate interestRate;
    private final int repaymentTerm;
    private final RepaymentMethodType repaymentMethod;

    public LoanCondition(BigDecimal amountOfMoneyBorrowed, InterestRate interestRate, int repaymentTerm, RepaymentMethodType repaymentMethod) {
        this.amountOfMoneyBorrowed = amountOfMoneyBorrowed;
        this.interestRate = interestRate;
        this.repaymentTerm = repaymentTerm;
        this.repaymentMethod = repaymentMethod;
    }

    public BigDecimal getAmountOfMoneyBorrowed() {
        return amountOfMoneyBorrowed;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public int getRepaymentTerm() {
        return repaymentTerm;
    }

    public RepaymentMethodType getRepaymentMethod() {
        return repaymentMethod;
    }
}
