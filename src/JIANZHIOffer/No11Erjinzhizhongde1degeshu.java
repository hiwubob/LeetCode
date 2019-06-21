package JIANZHIOffer;

public class No11Erjinzhizhongde1degeshu {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            count+=1;
            n = n & (n - 1);
        }
        return count;
    }
}
