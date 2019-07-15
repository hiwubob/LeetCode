package 回溯;

import java.util.LinkedHashMap;
import java.util.Map;
//https://blog.csdn.net/whdAlive/article/details/81411800

public class T146LRU {
	class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {
	    //定义缓存的容量
	    private int capacity;
	    private static final long serialVersionUID = 1L;
	    //带参数的构造器
	    LRULinkedHashMap(int capacity) {
	        //调用LinkedHashMap的构造器，传入以下参数,true代表开启LRU 缓存
	        super(capacity,0.75f,true);
	        //传入指定的缓存最大容量
	        this.capacity = capacity;
	    }
	    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
	    @Override
	    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
	        return size() > capacity;
	    }
	}

	class LRUCache {

	    LRULinkedHashMap<Integer, Integer> lruLinkedHashMap;

	    public LRUCache(int capacity) {
	        lruLinkedHashMap = new LRULinkedHashMap(capacity);
	    }

	    public int get(int key) {
	        Integer value = lruLinkedHashMap.get(key);
	        if (value == null)
	            return -1;
	        return value;
	    }

	    public void put(int key, int value) {
	        lruLinkedHashMap.put(key, value);
	    }
	}
}
