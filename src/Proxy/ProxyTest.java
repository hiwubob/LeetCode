package Proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public void test() {
        Object target = new PersonServiceImpl();
        Transation transation = new Transation();
        PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, transation);
        PersonService personService = (PersonService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
        String returnValue = personService.savePerson();
        System.out.println(returnValue);
    }

    public void test2() {
        Object target = new PersonServiceImpl();
        Transation transation = new Transation();
        PersonServiceInterceptor2 interceptor2 = new PersonServiceInterceptor2(target, transation);
        PersonService personService=(PersonService)interceptor2.createProxy();
        String returnValue = (String)personService.savePerson();
        System.out.println(returnValue);

    }
}
