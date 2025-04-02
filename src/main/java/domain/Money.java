package domain;

public class Money {

    private final long price;

    private Money(long price) {
        this.price = price;
    }

    public static Money from(long price) {
        return new Money(price);
    }

    public Money add(long addPrice) {
        return Money.from(price + addPrice);
    }
    public Money sub(long subPrice) {
        return Money.from(price - subPrice);
    }

    public long divideBy(long divisor) { return price / divisor; }

    public long getPrice() {
        return price;
    }

}
