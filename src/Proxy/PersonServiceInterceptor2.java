package Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//cglib
public class PersonServiceInterceptor2 implements MethodInterceptor {
    //Ŀ����
    private Object target;
    //��ǿ��
    private Transation transation;

    //���캯��ע��Ŀ�������ǿ��
    public PersonServiceInterceptor2(Object target, Transation transation) {
        this.target=target;
        this.transation=transation;
    }

    public Object createProxy(){
        //��ǿ�����
        Enhancer enhancer = new Enhancer();
//        ������ǿ����
        enhancer.setSuperclass(this.target.getClass());
//        ��������߼�����Ϊ��ǰ����Ҫ��ǰ����ʵ��MethordInterceptor����
        enhancer.setCallback(this);
//        ���ɲ����ش������
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
