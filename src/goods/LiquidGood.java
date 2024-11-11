package goods;


public class LiquidGood extends Product implements PricePerUnitable {
    //Interface Segregation Principle - применяем логически независимые интерфейсы вместо одного большого
    private double volumeLiters;

    public LiquidGood(String name, double price, double volumeLiters) {
        super(name, price);
        this.volumeLiters = volumeLiters;
    }

    public double getVolumeLiters() {
        return volumeLiters;
    }

    @Override
    public String pricePerUnit() {
        return " Цена за литр: " + Math.floor(getPrice() / volumeLiters * ROUNDING) / ROUNDING;
    }

    @Override
    public String toString() {
        return this.getName() + " Объём, л.: " + volumeLiters + " Цена " + getPrice() + " руб." + pricePerUnit() +
                " рейтинг: " + getRating();
    }
}
