package Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//cglib
public class PersonServiceInterceptor2 implements MethodInterceptor {
    //目标类
    private Object target;
    //增强类
    private Transation transation;

    //构造函数注入目标类和增强类
    public PersonServiceInterceptor2(Object target, Transation transation) {
        this.target=target;
        this.transation=transation;
    }

    public Object createProxy(){
        //增强类对象
        Enhancer enhancer = new Enhancer();
//        设置增强类型
        enhancer.setSuperclass(this.target.getClass());
//        定义代理逻辑对象为当前对象，要求当前对象实现MethordInterceptor方法
        enhancer.setCallback(this);
//        生成并返回代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        transation.beginTransation();
        Object returnValue = method.invoke(this.target, objects);
        transation.commit();
        return returnValue;
    }
}
