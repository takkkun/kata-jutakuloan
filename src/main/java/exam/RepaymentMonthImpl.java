package exam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class RepaymentMonthImpl implements RepaymentMonth {
    private final LocalDate month;

    public RepaymentMonthImpl(int year, int m) {
        month = LocalDate.of(year, m, 1);
    }

    private RepaymentMonthImpl(LocalDate month) {
        this.month = month;
    }

    @Override
    public RepaymentMonth nextMonth() {
        return new RepaymentMonthImpl(month.plusMonths(1));
    }

    @Override
    public Stream<RepaymentMonth> stream() {
        AtomicReference<RepaymentMonth> monthRef = new AtomicReference<>(this);
        return Stream.generate(() -> monthRef.updateAndGet(RepaymentMonth::nextMonth));
    }

    @Override
    public RepaymentMonth plusMonths(long months) {
        return new RepaymentMonthImpl(month.plusMonths(months));
    }

    @Override
    public boolean isBefore(RepaymentMonth other) {
        if (other instanceof LowerBoundRepaymentMonth) {
            return false;
        } else if (other instanceof RepaymentMonthImpl) {
            RepaymentMonthImpl impl = (RepaymentMonthImpl) other;
            return month.isBefore(impl.month);
        } else {
            throw new IllegalArgumentException(other.getClass() + " is not supported");
        }

    }

    @Override
    public long elapsedYears(final RepaymentMonth endExclusive) {
        if (endExclusive instanceof RepaymentMonthImpl) {
            return ChronoUnit.YEARS.between(month, ((RepaymentMonthImpl) endExclusive).month);
        } else {
            return endExclusive.elapsedYears(this);
        }
    }

    @Override
    public boolean equals(Object other) {
        return Optional.ofNullable(other)
                .filter(RepaymentMonthImpl.class::isInstance)
                .map(RepaymentMonthImpl.class::cast)
                .filter(m -> Objects.equals(m.month, month))
                .isPresent();
    }

    @Override
    public String toString() {
        return DateTimeFormatter.ISO_DATE.format(month);
    }

    @Override
    public int compareTo(final RepaymentMonth o) {
        if (o instanceof RepaymentMonthImpl) {
            return month.compareTo(((RepaymentMonthImpl) o).month);
        } else {
            return 1;
        }
    }
}
