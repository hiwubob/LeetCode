package 练手;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.HashMap;

public class lrutest<K,V> {
    class Node{
        Node pre;
        Node next;
        Object key;
        Object value;
        public  Node(){}
    }

    private int curSize;
    private int capacity;
    private Node first;
    private Node last;
    private HashMap<K, Node> map;

    public lrutest(int size){
        curSize=0;
        this.capacity=size;
        map=new HashMap<>();
    }

    public void put(K k, V v) {
        Node node = map.get(k);
        if (node == null) {
            if (map.size() + 1 >= capacity) {
                map.remove(last.key);
                removeLast();
            }
        }
        node.value=v;
        moveToFirst(node);
        map.put(k, node);
    }

    public Object get(K k) {
        Node node = map.get(k);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    public void remove(K k) {
        Node node = map.get(k);
        if (node != null) {
            if (node.pre != null) {
                node.pre.next=node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (first == node) {
                first=first.next;}
            if (last == node) {
                last = last.pre;
            }
        }
    }

    public void clear() {
        first=null;
        last=null;
        map.clear();
    }
    private void moveToFirst(Node node) {
        if (first == node) {
            return;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (first == null || last == null) {
            first=last=null;
            return;
        }
        node.next=first;
        first.pre=node;
        first=node;
        first.pre=null;
    }

    private void removeLast() {
        if (last != null) {
            last=last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next=null;
            }
        }
    }
}
