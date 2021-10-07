package exam;

import java.util.stream.Stream;

public interface Loan {
    Stream<RepaymentPerMonth> repaymentStream(RepaymentMonth startMonth);
}
