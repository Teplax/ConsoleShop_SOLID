package goods;


public abstract class Product implements Ratable{
    public static final double ROUND_RATING = 10.0;//Magic numbers principle - вместо чисел используются константы.
    // Если понадобится изменить разрядности округления - достаточно будет заменить соответствующую константу,
    // не нужно будет искать и изменять все мета, где они используются.
    public static final double ROUNDING = 100.0;
    private String name;
    private double price;
    private int voteSum;
    private int votesQantity;


    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getRating(){
        if(votesQantity>0){
        return String.valueOf(Math.round((float) voteSum /votesQantity*ROUND_RATING)/ROUND_RATING);
        }
        else return "Пока отсутствует";
    }

    public String getName(){
        return name;
    }

    @Override
    public void rate(int stars) {
        voteSum+=stars;
        votesQantity++;
    }
}
