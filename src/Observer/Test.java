package Observer;

public class Test {
    public static void main(String[] args) {
        ProductList observable=ProductList.getInstance();
        TaoBaoObserver taoBaoObserver=new TaoBaoObserver();
        JingDongObserver jingDongObserver=new JingDongObserver();
        observable.addObserver(jingDongObserver);
        observable.addObserver(taoBaoObserver);
        observable.addProduct("²úÆ·1");
    }
}
