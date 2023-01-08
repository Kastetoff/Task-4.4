import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (HashMap.Entry<String, Integer> productAndPrice : products.entrySet()) { /** замена Map на HashMap*/
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(products);
        while (true) {
            byte index = 0;
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[index++];
            int count = Integer.parseInt(parts[index++]);   /** тут не уверен, но [0] и [1] похожи на магические числа.
             Ведь мы знаем что будет 2 части (продукт и кол-во). В перспективе может добавиться 3й аргумент
             (например ед. измерения - {Масло, 3, (250гр/500гр...)} */
            basket.addToBasket(product, count);
        }
        long sum = basket.sum();
        System.out.println("ИТОГО: " + sum);
    }
}
