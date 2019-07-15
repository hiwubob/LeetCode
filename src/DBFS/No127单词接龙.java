package DBFS;

import java.util.*;

public class No127���ʽ��� {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {//̽������Ƿ�Ϊ�գ���Ϊ�յĻ�����ִ��������߼�
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                //����һ���ںУ���ǰ��word����������Щ�ṩ��words�е�word���ҳ���
                List<String> candidates = transform(words, word);
                for (String candidate : candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);//���ҵ���candidate���뵽queue��
                }
            }
        }
        return 0;
    }

    /**
     * ���ɵ�ǰword������candidates
     *
     * @param words �������ֵ�
     * @param word  ��Ҫ�Աȵ�word
     * @return
     */
    private List<String> transform(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);//��¼�µ�ǰword�ĵ�һ����ĸ����hit�����h��һ������¼��temp��
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {//��hit�ĵ�һλh��a-z����ĸһ��һ���滻�����жԱȣ���������Լ������ʱʱ��continue��
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = new String(sb);
                if (words.remove(newWord)) {//���words ������newWord���Ƴ�������newWord���뵽��ѡ�ߵ�list��
                    candidates.add(newWord);
                }

            }
            sb.setCharAt(i, temp);//�統ǰ�Ѿ�������z����hit����h�õ�zit����zit������ʼ��״̬��temp��¼���ǳ�ʼ״̬�ǵ�ʱ��ĸ
        }
        return candidates;
    }
}