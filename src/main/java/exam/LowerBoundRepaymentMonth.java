package exam;

import java.util.stream.Stream;

public class LowerBoundRepaymentMonth implements RepaymentMonth {
    @Override
    public RepaymentMonth nextMonth() {
        throw new UnsupportedOperationException("nextMonth");
    }

    @Override
    public Stream<RepaymentMonth> stream() {
        throw new UnsupportedOperationException("stream");
    }

    @Override
    public RepaymentMonth plusMonths(long months) {
        throw new UnsupportedOperationException("stream");
    }

    @Override
    public boolean isBefore(RepaymentMonth other) {
        return true;
    }

    @Override
    public String toString() {
        return "Lower bound";
    }
}