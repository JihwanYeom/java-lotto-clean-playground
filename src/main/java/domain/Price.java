package domain;

public class Price {

    private int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    public Price add(int addPrice) {
        return Price.from(price + addPrice);
    }

    public int getPrice() {
        return price;
    }

}
