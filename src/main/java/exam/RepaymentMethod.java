package exam;

import java.math.BigDecimal;

public interface RepaymentMethod {
    BigDecimal calcAmountOfPrincipalRepayment(BigDecimal interestRatePerMonth, BigDecimal balance);
    BigDecimal calcAmountOfInterestRepayment(BigDecimal interestRatePerMonth, BigDecimal balance);
}
