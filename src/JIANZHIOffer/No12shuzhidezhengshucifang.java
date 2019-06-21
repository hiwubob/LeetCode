package JIANZHIOffer;

public class No12shuzhidezhengshucifang {
    public double Power(double base, int exponent) {
        double tmp=1;
        if (exponent > 1) {
            for (int i = 1; i <=exponent; i++) {
                tmp=tmp*base;
                if(tmp>1.7976931348623157E308){
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            return tmp;
        } else if (exponent < 0) {
            exponent = -exponent;
            for (int i = 1; i <= exponent; i++) {
                tmp = tmp * base;
                if (tmp > 1.7976931348623157E308) {
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            tmp = 1 / tmp;
            return tmp;
        } else {
            return 1;
        }
    }
}
