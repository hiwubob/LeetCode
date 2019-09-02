package ±  ‘;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class lrujava {
    private int size;
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    class Node{
        Node pre;
        Node next;
    }
    public lrujava(int size) {
        this.size=size;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == size) {
            Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}
