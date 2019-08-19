package JIANZHIOffer;

public class No49 {
    public int StrToInt(String string) {
        if (string.length() == 0) {
            return 0;
        }
        int flag=0;
        if (string.charAt(0) == '+') {
            flag=1;
        } else if (string.charAt(0) == '-') {
            flag=2;
        }

        int i = flag > 0 ? 1 : 0;
        long res=0;
        while (i < string.length()) {
            if (string.charAt(i) > '9' || string.charAt(i) < '0') {
                return 0;
            }
            res = res * 10 + (string.charAt(i) - '0');
            i++;
        }
        return (int) res;
    }
}
