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
    public long elapsedYears(final RepaymentMonth endExclusive) {
        throw new UnsupportedOperationException("elapsedYears");
    }

    @Override
    public String toString() {
        return "Lower bound";
    }

    @Override
    public int compareTo(final RepaymentMonth o) {
        if (o instanceof RepaymentMonthImpl) {
            return -1;
        } else {
            return 0;
        }
    }
}
