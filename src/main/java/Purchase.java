public class Purchase {
    /**
     * принцип единственной ответственности - класс отвечает за выбор продуктов, не более
     */
    protected String product;
    /**
     * назв. переменной title заменено на product (как в Main).
     */
    protected int count;

    public Purchase(String title, int count) {
        this.product = title;
        this.count = count;
    }
}
