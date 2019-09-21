package ����;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class xiaohongshu3 {
    /**
     ���������ʽ
     ��һ����������n,m��
     2 2
     ����n�У�ÿ��m���ַ���
     S#
     #G
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = sc.nextLine();

        char [][] map = new char [n][n];

        int[] begin = new int [2];
        int[] end = new int [2];

        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            map[i] = s.toCharArray();

            if(s.contains("S")) {
                begin[0] = i;
                begin[1] = s.indexOf("S");
            }
            if(s.contains("E")) {
                end[0] = i;
                end[1] = s.indexOf("E");
            }
        }
        System.out.println(bfs(map, begin, end));

    }
    public static int bfs(char [][] map, int [] begin, int [] end) {
        //�ƶ����ĸ�����
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        //����������뵽��ʼ�����·���Ķ�ά����
        int[][] d = new int [map.length][map[0].length];
        //����δ���д���ĵ�
        Queue<int []> que = new LinkedList<int []>();
        //�����е�λ�ö���ʼ��Ϊ���
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        //����ʼ��������
        que.offer(begin);
        //����ʼ�����·����Ϊ0
        d[ begin[0] ][ begin[1] ] = 0;
        //һֱѭ��ֱ������Ϊ��
        while(!que.isEmpty()) {
            //ȡ����������ǰ�˵ĵ�
            int [] current = que.poll();
            //������յ������
            if(current[0] == end[0] && current[1] == end[1]) break;
            //�ĸ�����ѭ��
            for(int i = 0; i < 4; i++) {
                //��̽
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if (ny >= d.length) {
                    ny=0;
                }
                if (ny < 0) {
                    ny=d.length-1;
                }
                if (nx < 0) {
                    nx=d[0].length-1;
                }
                if (nx >= d.length) {
                    nx=0;
                }
                if(map[ny][nx] != '#' && d[ny][nx] == Integer.MAX_VALUE) {
                    //��������ߣ��򽫸õ�ľ����1
                    d[ny][nx] = Math.min(d[ny][nx],d[current[0]][current[1]] + 1);
                    //�����õ������еȴ��´δ���
                    int[] c = {ny, nx};
                    que.offer(c);

                }
            }
        }

        return d[end[0]][end[1]];
    }

}
