package DBFS;

import java.io.StringReader;
import java.util.*;

public class T217ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int ans = 0;

        boolean[] hashset = new boolean[wordList.size()];
        Deque<String> queue = new ArrayDeque();
        queue.offer(beginWord);
        for (int i = 0; i < wordList.size(); i++)
            if (wordList.get(i).equals(beginWord))
                hashset[i] = true;

        while (!queue.isEmpty()) {
            int n = queue.size();
            ans++;
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord))
                    return ans;
                for (int j = 0; j < wordList.size(); j++)
                    if (!hashset[j] && isLegal(cur, wordList.get(j))) {
                        hashset[j] = true;
                        queue.offer(wordList.get(j));
                    }
            }

        }

        return 0;
    }


    boolean isLegal(String s1, String s2) {


        int sum = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                sum++;
        return sum == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> l = new ArrayList<>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");
        T217ladderLength t = new T217ladderLength();
        int i = t.ladderLength(beginWord, endWord, l);
        System.out.println(i);


    }
}