package Annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvicer = "��Ӧ����Ϣ��";
        Field[] fields=clazz.getDeclaredFields();
        for (Field field :
                fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvicer="��Ӧ��"+fruitProvider.id()+"��Ӧ�����ƣ�"+fruitProvider.name()+"��Ӧ�̵�ַ��"+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
