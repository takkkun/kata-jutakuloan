# プログラミング演習問題 (ローン返済)

ローンの条件には、以下のものがあります。
- 借り入れ金額
- 金利(年利)
- 返済期間(年)

ローン返済計画のを表すRepaymentPerMonthのStreamを実装してください。
RepaymentPerMonthは、以下のフィールドを持ちます。

- 返済回数(何回目か?)
- 返済年月
- 元金返済額
- 利息返済額
- ローン残高

```java
public interface Loan {
    Stream<RepaymentAmountPerMonth> repaymentStream(RepaymentMonth startMonth);
}

public class RepaymentPerMonth implements Serializable {
    /** 返済回数(何回目か?) */
    private final int times;

    /** 返済年月 */
    private final RepaymentMonth month;

    /** 元金返済額 */
    private final BigDecimal principal;

    /** 利息返済額 */
    private final BigDecimal interest;

    /** ローン残高 */
    private final BigDecimal balance;
}
```