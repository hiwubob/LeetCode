package ����;

import java.util.Arrays;
import java.util.Scanner;

public class ͷ��1 {
    static class Time {
        int hour;
        int minute;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time();
            times[i].hour = sc.nextInt();
            times[i].minute = sc.nextInt();
        }
        Arrays.sort(times, (c1, c2)->{return c1.hour == c2.hour ? c1.minute-c2.minute : c1.hour - c2.hour;});
        int time = sc.nextInt();
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int h = time/60;
        int m = time%60;
        int h1, m1;
        if (m > min) {
            h1 = hour - h -1;
            m1 = 60 + min - m;
        } else {
            h1 = hour - h;
            m1 = min - m;
        }
        int index = 0;
        for (int i = n-1; i >0 ; i--) {
            if (times[i].hour> h1) {
                continue;
            } else if (times[i].hour == h1 && times[i].minute>m1) {
                continue;
            } else if (times[i].hour == h1 && times[i].minute<=m1) {
                index = i;
                break;
            }else if (times[i].hour < h1) {
                index = i;
                break;
            }
        }
        System.out.print(times[index].hour);
        System.out.print(" ");
        System.out.println(times[index].minute);
    }

}