package Proxy;

public class PersonServiceImpl implements PersonService {


    @Override
    public String savePerson() {
        System.out.println("���");
        return "����ɹ�";
    }

    @Override
    public void updatePerson() {
        System.out.println("����");
    }

    @Override
    public void deletePerson() {
        System.out.println("ɾ��");

    }
}
