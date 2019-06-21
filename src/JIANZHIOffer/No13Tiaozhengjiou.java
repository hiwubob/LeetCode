package JIANZHIOffer;

public class No13Tiaozhengjiou {
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i]=tmp;
                }
            }
        }
    }
}
