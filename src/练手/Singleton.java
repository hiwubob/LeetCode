package 练手;

public class Singleton {
    private Singleton(){};

    private static volatile Singleton singleton=null;

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    static class Singletonerhan{
        public Singletonerhan(){};
        public static Singletonerhan singletonerhan=new Singletonerhan();

        public static Singletonerhan getInstance() {
            return singletonerhan;
        }
    }
}
