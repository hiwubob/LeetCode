package ����;

import java.util.HashMap;
import java.util.Scanner;


public class aiqiyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size=sc.nextInt();
        LRUCache<String, String> lru = new LRUCache<String, String>(size);
        while (sc.hasNext()) {
            lru.put(sc.next(), sc.next());
        }
    }
    static class LRUCache<K, V> {

        class CacheNode {
            CacheNode pre;
            CacheNode next;
            Object key;
            Object value;

            public CacheNode() {

            }
        }

        private int currentCacheSize;
        private int CacheCapcity;
        private HashMap<K, CacheNode> caches;
        private CacheNode first;
        private CacheNode last;

        public LRUCache(int size) {
            currentCacheSize = 0;
            this.CacheCapcity = size;
            caches = new HashMap<K, CacheNode>(size);
        }

        public void put(K k, V v) {
            CacheNode node = caches.get(k);
            if (node == null) {
                if (caches.size() >= CacheCapcity) {
                    caches.remove(last.key);
                    System.out.println(last.key+" "+last.value);
                    removeLast();
                }
                node = new CacheNode();
                node.key = k;
            }
            node.value = v;
            moveToFirst(node);
            caches.put(k, node);
        }

        public Object get(K k) {
            CacheNode node = caches.get(k);
            if (node == null) {
                return null;
            }
            moveToFirst(node);
            return node.value;
        }

        public Object remove(K k) {
            CacheNode node = caches.get(k);
            if (node != null) {
                if (node.pre != null) {
                    node.pre.next = node.next;
                }
                if (node.next != null) {
                    node.next.pre = node.pre;
                }
                if (node == first) {
                    first = node.next;
                }
                if (node == last) {
                    last = node.pre;
                }
            }

            return caches.remove(k);
        }

        public void clear() {
            first = null;
            last = null;
            caches.clear();
        }


        private void moveToFirst(CacheNode node) {
            if (first == node) {
                return;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node == last) {
                last = last.pre;
            }
            if (first == null || last == null) {
                first = last = node;
                return;
            }

            node.next = first;
            first.pre = node;
            first = node;
            first.pre = null;

        }

        private void removeLast() {
            if (last != null) {
                last = last.pre;
                if (last == null) {
                    first = null;
                } else {
                    last.next = null;
                }
            }
        }

    }
}
