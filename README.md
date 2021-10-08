# プログラミング演習問題 (ローン返済)

ローンの条件には、以下のものがあります。
- 借り入れ金額
- 金利(年利)
- 返済期間(年)

ローン返済計画のを表すRepaymentPerMonthのStreamを返すLoanクラスを実装してください。
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

## 返済額の計算式

返済額の計算は元利均等返済と元金均等返済の2通りが選べる。
それぞれの計算式を以下に示す。

計算の過程で出た端数は、すべて切り上げとします。

```
Rm: 毎月返済額
Ri: 利息返済額
Rp: 元金返済額
r: 借入金額
Im: 月利
T: 返済回数
b: 直前のローン残高
```

### 元利均等返済

![](https://latex.codecogs.com/gif.latex?Rm%20%3D%20%5Cfrac%7Bb%20%5Ctimes%20i%20%5Ctimes%20%281%20&plus;%20Im%29%5E%7BT%7D%7D%7B%281%20&plus;%20Im%29%5E%7BT%7D%20-%201%7D)

![](https://latex.codecogs.com/gif.latex?Ri%20%3D%20b%20%5Ctimes%20Im)

![](https://latex.codecogs.com/gif.latex?Rp%20%3D%20Rm%20-%20Ri)


### 元金均等返済

![](https://latex.codecogs.com/gif.latex?Rm%20%3D%20%5Cfrac%7Br%7D%7BT%7D)

![](https://latex.codecogs.com/gif.latex?Ri%20%3D%20b%20%5Ctimes%20Im)

![](https://latex.codecogs.com/gif.latex?Rm%20%3D%20Rp%20&plus;%20Ri)

