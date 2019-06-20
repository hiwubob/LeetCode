package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//动态代理
public class PersonServiceInterceptor implements InvocationHandler {
    //目标类
    private Object target;
    //增强类
    private Transation transation;
    //构造函数注入目标类和增强类
    public PersonServiceInterceptor(Object target,Transation transation){
        this.target=target;
        this.transation=transation;
    }
    //代理类的每一个方法被调用的时候都会调用下边的这个invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.transation.beginTransation();
        Object returnValue = method.invoke(this.target, args);
        this.transation.commit();
        return returnValue;
    }
}
