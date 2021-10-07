package exam;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepaymentMonthTest {
    @Test
    void stream() {
        RepaymentMonth month = RepaymentMonth.of(2021, 10);
        assertThat(month.stream().limit(10)).hasSize(10)
                .contains(
                        RepaymentMonth.of(2021, 11),
                        RepaymentMonth.of(2021, 12),
                        RepaymentMonth.of(2022, 1),
                        RepaymentMonth.of(2022, 2),
                        RepaymentMonth.of(2022, 3),
                        RepaymentMonth.of(2022, 4),
                        RepaymentMonth.of(2022, 5),
                        RepaymentMonth.of(2022, 6),
                        RepaymentMonth.of(2022, 7),
                        RepaymentMonth.of(2022, 8)
                        );
    }
}