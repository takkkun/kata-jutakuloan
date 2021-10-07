package exam;

import net.unit8.kysymys.scorer.SutDetector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class InterestRateTest {
    InterestRateFactory interestRateFactory;

    @BeforeEach
    void setup() {
        interestRateFactory = SutDetector.detect(InterestRateFactory.class);
    }

    @Test
    void floating() {
        FloatingInterestRate rate = interestRateFactory.createFloatingInterestRate(new BigDecimal("0.01"));
        rate.addRate(RepaymentMonth.of(2021, 6), new BigDecimal("0.012"));
        rate.addRate(RepaymentMonth.of(2021, 3), new BigDecimal("0.011"));
        assertThat(rate.getRate(RepaymentMonth.of(2021, 2))).isEqualTo("0.01");
        System.out.println(rate);
    }

    @Test
    void fixed() {
        FixedInterestRate rate = interestRateFactory.createFixedInterestRate(new BigDecimal("0.00625"));
        assertThat(rate.getRate(RepaymentMonth.of(2048, 10), RepaymentMonth.of(2021, 10))).isEqualTo("0.00625");
    }

    @Test
    void limitedFixed() {
        FloatingInterestRate floatingInterestRate = interestRateFactory.createFloatingInterestRate(new BigDecimal("0.01"));
        FixedInterestRate rate = interestRateFactory.createLimitedFixedInterestRate(new BigDecimal("0.00625"), 5, floatingInterestRate);
        assertThat(rate.getRate(RepaymentMonth.of(2025, 10), RepaymentMonth.of(2021, 10)))
                .isEqualTo("0.00625");
        assertThat(rate.getRate(RepaymentMonth.of(2027, 11), RepaymentMonth.of(2021, 10)))
                .isEqualTo("0.01");
    }
}