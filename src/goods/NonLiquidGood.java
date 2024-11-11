package goods;

public class NonLiquidGood extends Product implements PricePerUnitable {
    private final double weight;

    public NonLiquidGood(String name, double price, double weightInKilos) {
        super(name, price);
        weight = weightInKilos;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String pricePerUnit() {
        return " Цена за килограмм: " + Math.floor(getPrice() / weight * ROUNDING) / ROUNDING;
    }

    @Override
    public String toString() {
        return this.getName() + " Вес, кг.: " + weight + " цена " + getPrice() + " руб." + pricePerUnit() +
                " рейтинг: " + getRating();
    }

}
