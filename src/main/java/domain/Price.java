package domain;

public class Price {

    private final int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    public Price add(int addPrice) {
        return Price.from(price + addPrice);
    }

    public int divideBy(int divisor) { return price / divisor; }

    public int getPrice() {
        return price;
    }

}
