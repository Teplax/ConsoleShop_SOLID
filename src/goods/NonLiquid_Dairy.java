package goods;

public class NonLiquid_Dairy extends NonLiquidGood {
    //Open-Closed principle - наследуя от класса NonLiquidGood мы расширяем функциональность и ассортимент магазина
    //путём добавления новых классов, а не изменения исходных
    private final double fatContent;

    public NonLiquid_Dairy(String name, double price, double weigth, double fatContent) {
        super(name, price, weigth);
        this.fatContent = fatContent;
    }

    @Override
    public String toString() {
        return this.getName() + " Масса, кг.: " + this.getWeight() + " Жирность, %:" + fatContent
                + " цена " + getPrice() + " руб." + pricePerUnit() + " рейтинг: " + getRating();
    }
}
