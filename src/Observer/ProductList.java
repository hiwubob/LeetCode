package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
//    产品列表
    private List<String> productList=null;
//    类唯一实例
    private static ProductList instance;

    private ProductList() {
    }

    //    取得唯一实例
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    //增加观察者
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    //    添加产品
    public void addProduct(String newProduct) {
        productList.add(newProduct);
        System.out.println("产品列表发生变化" + newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }
}
