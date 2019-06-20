package Annotation;

public class Apple {
    @FruitProvider(id = 1, name = "shanxi", address = "shanxi")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}
