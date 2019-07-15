package DBFS;

import java.util.*;

public class No127单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {//探测队列是否为空，不为空的话继续执行下面的逻辑
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                //当做一个黑盒，当前的word可以生成哪些提供的words中的word，找出来
                List<String> candidates = transform(words, word);
                for (String candidate : candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);//将找到的candidate加入到queue中
                }
            }
        }
        return 0;
    }

    /**
     * 生成当前word后续的candidates
     *
     * @param words 所给的字典
     * @param word  需要对比的word
     * @return
     */
    private List<String> transform(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);//记录下当前word的第一个字母，如hit这个的h第一个，记录到temp中
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {//当hit的第一位h被a-z的字母一个一个替换掉进行对比，当其等于自己本身的时时候，continue掉
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = new String(sb);
                if (words.remove(newWord)) {//如果words 中有新newWord，移除掉并将newWord加入到候选者的list中
                    candidates.add(newWord);
                }

            }
            sb.setCharAt(i, temp);//如当前已经遍历到z后，如hit换掉h得到zit，将zit换到初始的状态，temp记录的是初始状态是的时字母
        }
        return candidates;
    }
}