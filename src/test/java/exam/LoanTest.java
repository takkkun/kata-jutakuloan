package exam;

import net.unit8.kysymys.scorer.SutDetector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LoanTest {
    InterestRateFactory interestRateFactory;
    LoanFactory loanFactory;

    @BeforeEach
    public void setup() {
        interestRateFactory = SutDetector.detect(InterestRateFactory.class);
        loanFactory = SutDetector.detect(LoanFactory.class);
    }

    @Test
    public void fixed30Years() {
        LoanCondition condition = new LoanCondition(new BigDecimal("30000000"),
                interestRateFactory.createFixedInterestRate(new BigDecimal("0.012")),
                30,
                RepaymentMethodType.PRINCIPAL_AND_INTEREST_EQUAL);
        Loan loan = loanFactory.create(condition);
        assertThat(loan.repaymentStream(RepaymentMonth.of(2021, 10))
                .map(RepaymentPerMonth::getPrincipal)
                .mapToInt(BigDecimal::intValue)
                .sum()).isEqualTo(30_000_000);

        assertThat(loan.repaymentStream(RepaymentMonth.of(2021, 10))
                .map(RepaymentPerMonth::getInterest)
                .mapToInt(BigDecimal::intValue)
                .sum()).isEqualTo(5_738_333);
    }

    @Test
    public void floating30years() {
        LoanCondition condition = new LoanCondition(new BigDecimal("30000000"),
                interestRateFactory.createFixedInterestRate(new BigDecimal("0.012")),
                30,
                RepaymentMethodType.PRINCIPAL_EQUAL_MONTHLY);

        Loan loan = loanFactory.create(condition);

        assertThat(loan.repaymentStream(RepaymentMonth.of(2021, 10))
                .map(RepaymentPerMonth::getPrincipal)
                .mapToInt(BigDecimal::intValue)
                .sum()).isEqualTo(30_000_000);

        assertThat(loan.repaymentStream(RepaymentMonth.of(2021, 10))
                .map(RepaymentPerMonth::getInterest)
                .mapToInt(BigDecimal::intValue)
                .sum()).isEqualTo(5_415_120);
    }

}