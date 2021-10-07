package exam;

public interface LoanFactory {
    Loan create(LoanCondition condition);
}
