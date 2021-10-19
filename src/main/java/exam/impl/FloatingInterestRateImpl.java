package exam.impl;

import exam.FloatingInterestRate;
import exam.RepaymentMonth;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FloatingInterestRateImpl implements FloatingInterestRate {

    private final Map<RepaymentMonth, BigDecimal> rates = new HashMap<>();

    public FloatingInterestRateImpl(final BigDecimal initialRate) {
        rates.put(RepaymentMonth.LOWER, initialRate);
    }

    @Override
    public void addRate(final RepaymentMonth month, final BigDecimal rate) {
        if (rates.containsKey(month)) {
            throw new IllegalArgumentException(String.format("the rate after %s is already added", month));
        }
        rates.put(month, rate);
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month, final RepaymentMonth startMonth) {
        return getRate(month);
    }

    @Override
    public BigDecimal getRate(final RepaymentMonth month) {
        final var maxMonth = rates.keySet().stream()
            .filter(m -> m.equals(month) || m.isBefore(month))
            .max(Comparator.naturalOrder());
        return maxMonth
            .map(rates::get)
            .orElseThrow(() -> new IllegalArgumentException(String.format("the rate after %s is missing", month)));
    }
}
