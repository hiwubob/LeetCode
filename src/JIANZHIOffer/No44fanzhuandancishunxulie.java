package JIANZHIOffer;

public class No44fanzhuandancishunxulie {
    //    反转单词顺序列
    public String reverse(String str) {
        if (str.length() == 0) {
            return str;
        }
        int i=0;
        int j=0;
        int len=str.length();
        char[] chars=str.toCharArray();
        while (j < len) {
            if (j == len || str.charAt(j) == ' ') {
                reverse(chars,i,j-1);
                i=j+1;
            }
            j++;
        }

        swap(chars, 0, len - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        swap(chars, i++, j++);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }
}
