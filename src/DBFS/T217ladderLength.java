package DBFS;

import java.io.StringReader;
import java.util.*;

public class T217ladderLength {
    /**
     * 127. 单词接龙
     * Word Ladder
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {
        /*
         * 这里是为了排除endWord不在wordList中的情况，不然下面遍历的时候endWord变化一位就
         * 在wordList中了。
         */
        if (!wordList.contains(endWord)) {
            return 0;
        }
        /*
         * bfs就是把每次筛选出来的节点保存到一个Set中，然后再次逐个遍历
         */
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (beginSet.size() > 0) {
            for (String b : beginSet) {
                wordList.remove(b);
            }
            step++;
            Set<String> tempSet = new HashSet<>();
            for (String b : beginSet) {
                for (Iterator<String> iterator = wordList.iterator();
                     iterator.hasNext(); ) {
                    String w = iterator.next();
                    if (diff(b, w) > 1) {
                        continue;
                    } else {
                        if (endSet.contains(w)) {
                            return step;
                        } else {
                            tempSet.add(w);
                            /*
                             * 本来想提前遍历删除的，结果失败了
                             * 这里也要注意，在遍历List的时候删除有两种办法：
                             * 1. iterator 这里采用此种方法
                             * 2. 倒序遍历删除
                             */
//                            wordList.remove(w);
//                            iterator.remove();
                        }
                    }
                }
            }
            /*
             * 这里的tempSet其实是nextBeginSet, 判断一下从哪边走简单就从哪边走
             */
            if (tempSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = tempSet;
            } else {
                beginSet = tempSet;
            }
        }
        return 0;
    }

    private int diff(String w1, String w2) {
        int deviation = 0;
        for (int i = 0; i < w1.length() && deviation < 2; ++i) {
            if (w1.charAt(i) != w2.charAt(i)) {
                ++deviation;
            }
        }
        return deviation;
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