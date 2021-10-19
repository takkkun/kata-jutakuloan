package exam.impl;

import exam.Loan;
import exam.LoanCondition;
import exam.LoanFactory;

public class LoanFactoryImpl implements LoanFactory {

    @Override
    public Loan create(final LoanCondition condition) {
        return new LoanImpl(condition);
    }
}
