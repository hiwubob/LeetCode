package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//��̬����
public class PersonServiceInterceptor implements InvocationHandler {
    //Ŀ����
    private Object target;
    //��ǿ��
    private Transation transation;
    //���캯��ע��Ŀ�������ǿ��
    public PersonServiceInterceptor(Object target,Transation transation){
        this.target=target;
        this.transation=transation;
    }
    //�������ÿһ�����������õ�ʱ�򶼻�����±ߵ����invoke����
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.transation.beginTransation();
        Object returnValue = method.invoke(this.target, args);
        this.transation.commit();
        return returnValue;
    }
}
