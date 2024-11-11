package goods;

public class Liquid_Dairy extends LiquidGood {
    //Single-responsibility principle - класс Liquid_Dairy описывает только группу жидких молочных продуктов,
    // а не все молочные продуты, или продукты вообще
    private final double fatContent;

    public Liquid_Dairy(String name, double price, double volume, double fatContent) {
        super(name, price, volume);
        this.fatContent = fatContent;
    }

    @Override
    public String toString() {
        return this.getName() + " Объём, л.: " + this.getVolumeLiters() + " Жирность, %:" + fatContent
                + " цена " + getPrice() + " руб." + pricePerUnit() + " рейтинг: " + getRating();
    }
}
