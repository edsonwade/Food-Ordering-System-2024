package code.with.vanilson.Money;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@EqualsAndHashCode
public class Money {
    private final BigDecimal amount;

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public boolean isGreaterThanZero() {
        return (this.amount != null) && (this.amount.compareTo(BigDecimal.ZERO) > 0);

    }

    public boolean isGreaterThan(Money money) {
        return (this.amount != null) && (this.amount.compareTo(money.getAmount()) > 0);

    }

    public Money add(Money money) {
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    public Money subtractMoney(Money money) {
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiplyAmountAndReturnAnInteger(int amount) {
        return new Money(setScale(this.amount.multiply(new BigDecimal(amount))));
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * With scale of digits after decimal point is 2
     *
     * @param inputBigDecimal bigDecimal
     * @return value on a scale of two
     */
    public BigDecimal setScale(BigDecimal inputBigDecimal) {
        return inputBigDecimal.setScale(2, RoundingMode.HALF_EVEN);
    }

}
