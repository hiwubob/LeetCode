package »ØËÝ;

public class T1012 {
	boolean[] isUsed = new boolean[10];
	int n;
	int index = 1;
	int count = 0;
	int nindex;

	public int numDuDigitsAtMostN(int N) {
		n = N;
		int tlength = String.valueOf(N).length();
		for (int i = 1; i <= tlength; i++) {
			nindex = i;
			for (int j = 1; j < 10; j++) {
				isUsed[j] = true;
				dfs(j);
				isUsed[j] = false;

			}
			index = 1;
		}
		return N - count;
	}

	private void dfs(int tmp) {
		if (tmp > n) {
			return;
		}
		if (index == nindex) {
			count++;
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (tmp * 10 > n) {
				break;
			}
			if (!isUsed[i]) {
				isUsed[i] = true;
				index++;
				dfs(tmp * 10 + i);
				index--;
				isUsed[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		T1012 t=new T1012();
		int N=20;
		int res=t.numDuDigitsAtMostN(N);
		System.out.println(res);
	}
}
