package domain;

public class ProfitRate {

    private final double profitRate;

    private ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate of(Money price, Money totalPrize ) {
        return new ProfitRate((double) totalPrize.getPrice() / price.getPrice());
    }

    public double getProfitRate() {
        return profitRate;
    }

}
