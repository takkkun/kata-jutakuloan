package exam;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@FunctionalInterface
public interface RepaymentMethodFactory extends BiFunction<BigDecimal, Integer, RepaymentMethod> {
    RepaymentMethod apply(BigDecimal amountOfMoneyBorrowed, Integer numberOfRepayments);
}
