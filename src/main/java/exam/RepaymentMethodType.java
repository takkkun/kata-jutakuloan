package exam;

public enum RepaymentMethodType {
    PRINCIPAL_AND_INTEREST_EQUAL("元利均等返済"),
    PRINCIPAL_EQUAL_MONTHLY("元金均等返済");

    private final String label;
    RepaymentMethodType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
