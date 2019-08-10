package »ØËÝ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T91fuyuanIPdizhi {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    public List<String> restoreIpAddress(String s) {
        n = s.length();
        this.s=s;
        dfs(-1,3);
        return output;
    }

    private void dfs(int prev_pos, int dots) {
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots-1==0)
                    update_output(curr_pos);
                else
                    dfs(curr_pos, dots - 1);
                segments.removeLast();
            }
        }
    }

    public boolean valid(String segment) {
        int m=segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0)!='0'?(Integer.valueOf(segment)<=255):(m==1));
    }

    public void update_output(int curr_pos){
        String segment = s.substring(curr_pos + 1, n);

    }
}
