package Proxy;

public class Transation {
    public void beginTransation() {
        System.out.println("开启事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }
}
