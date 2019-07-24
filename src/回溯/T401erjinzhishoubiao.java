package »ØËİ;

import java.util.ArrayList;
import java.util.List;

public class T401erjinzhishoubiao {

	int[] time = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
	private List<String> ret;

	public List<String> readBinaryWatch(int num) {
		ret = new ArrayList<String>();
		if (num < 0) {
			return ret;
		}
		read(num, 0, 0, 0);
		return ret;
	}

	private void read(int num, int index, int h, int m) {
		if (num == 0) {
			ret.add(h + ":" + (m < 10 ? "0" + m : m));
			return;
		}
		for (int i = index; i < time.length; i++) {
			if(i<=3) {
				if(h+time[i]>11) {
					continue;
				}
				read(num-1,i+1,h+time[i],m);
			}else {
				if(m+time[i]>59) {
					break;
				}
				read(num-1,i+1,h,m+time[i]);
			}
		}
	}
}
