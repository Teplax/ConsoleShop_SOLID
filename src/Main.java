import goods.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Liquid_Dairy milk = new Liquid_Dairy("Молоко Весёлый молочник", 125, 1.4, 3.2);
        Liquid_Dairy kefir = new Liquid_Dairy("Кефир Пискарёвский", 79.9, 0.9, 2.5);
        NonLiquid_Dairy curd = new NonLiquid_Dairy("Творог Вкуснотеево", 390, 0.4, 9);
        NonLiquid_Dairy butter = new NonLiquid_Dairy("Сливочное масло Labas Ritas", 240, 0.18, 82.5);
        NonLiquidGood blackBread = new NonLiquidGood("Хлеб Дарницкий", 39.9, 0.4);
        NonLiquidGood whiteBread = new NonLiquidGood("Батон Нарезной", 49.9, 0.7);
        LiquidGood water = new LiquidGood("Вода Шишкин лес", 80, 0.9);
        LiquidGood cocaCola = new LiquidGood("Напиток газированный Coca-Cola", 80, 0.5);

        Product[] products = {milk, kefir, curd, butter, blackBread, whiteBread, water, cocaCola};
        //Liskov substitution principle - наследники класса Product полностью играют роль предка
        System.out.println("Добро пожаловать в наш магазин!");

        printCatalogue(products);
        //принци DRY - повторяющийся код вывода каталога вынесен в отдельный метод

        Map<Product, Integer> basket = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("end")) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1: добавить товар в корзину");
            System.out.println("2: оценить товар");
            System.out.println("3: рассчитаться");
            System.out.println("4: вывести каталог");
            System.out.println("end - выйти из магазина");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Введите номер товара и количество: ");
                    int[] parts1 = patrtInput(scanner);
                    // принцип DRY - повторяющийся код разделения ввода на части вынесен в отдельный метод
                    basket.put(products[parts1[0]], parts1[1]);
                    System.out.println("Товар" + products[parts1[0]].getName() + " успешно добавлен!");
                    break;
                case "2":
                    System.out.println("Введите номер товара и вашу оценку от 1 до 5: ");
                    int[] parts2 = patrtInput(scanner);
                    products[parts2[0]].rate(parts2[1]);
                    break;
                case "3":
                    double summa = 0.0;
                    for (Product key : basket.keySet()) {
                        System.out.println(key + " количество: " + basket.get(key));
                        summa += key.getPrice() * basket.get(key);
                    }
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.printf("Итого: %s руб.", df.format(summa));
                    break;
                case "4":
                    printCatalogue(products);

            }


        }

    }

    public static int[] patrtInput(Scanner scanner) {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        return new int[]{Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1])};
    }

    private static void printCatalogue(Product[] products) {
        System.out.println("Каталог товаров, доступных для покупки:");
        int i = 1;
        for (Product product : products) {
            System.out.println(i++ + ": " + product);
        }
    }
}