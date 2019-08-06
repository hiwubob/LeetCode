package ±  ‘;

import java.util.HashMap;
import java.util.Scanner;

public class dajiang3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(sc.next(),sc.next());
            }
            for (int j = 0; j < m; j++) {
                System.out.println(map.get(sc.next()));
            }
        }
    }
}
