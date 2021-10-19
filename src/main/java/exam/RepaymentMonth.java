package exam;

import java.util.stream.Stream;

public interface RepaymentMonth extends Comparable<RepaymentMonth> {
    RepaymentMonth LOWER = new LowerBoundRepaymentMonth();

    RepaymentMonth nextMonth();

    Stream<RepaymentMonth> stream();

    RepaymentMonth plusMonths(long months);

    boolean isBefore(RepaymentMonth other);

    long elapsedYears(RepaymentMonth endExclusive);

    static RepaymentMonth of(int year, int month) {
        return new RepaymentMonthImpl(year, month);
    }
}
