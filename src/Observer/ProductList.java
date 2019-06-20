package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
//    ��Ʒ�б�
    private List<String> productList=null;
//    ��Ψһʵ��
    private static ProductList instance;

    private ProductList() {
    }

    //    ȡ��Ψһʵ��
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    //���ӹ۲���
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    //    ��Ӳ�Ʒ
    public void addProduct(String newProduct) {
        productList.add(newProduct);
        System.out.println("��Ʒ�б����仯" + newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }
}
