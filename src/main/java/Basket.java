import java.util.HashMap;

public class Basket {
    /**
     * принцип единственной ответственности - класс отвечает за продукты, добавленные в корзину
     */
    protected Purchase[] purchases;
    protected HashMap<String, Integer> prices;

    public Basket(HashMap<String, Integer> prices) {
        this.purchases = new Purchase[prices.size()]; /** Магичеслое число [4] заменено на переданный параметром размер списка продуктов*/
        this.prices = prices;
    }

    public void addToBasket(String product, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(product, count);
                return;
            }
            if (purchases[i].product.equals(product)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.product + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.product)) + " руб.");
            sum += purchase.count * prices.get(purchase.product);
        }
        return sum;
    }
}
