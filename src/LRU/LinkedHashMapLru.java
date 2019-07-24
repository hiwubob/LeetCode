package LRU;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedHashMapLru<K,V>extends LinkedHashMap<K,V> {
    private final int maxCapacity;
    private static final float DEFAULT_LOAD_FACTOR=0.75f;
    private final Lock lock = new ReentrantLock();

    public LinkedHashMapLru(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);//!!!!!!accessOrder
        this.maxCapacity=maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size()>maxCapacity;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        }finally {
            lock.unlock();
        }

    }

    public void clear() {
        try {
            lock.lock();
            super.clear();
        }finally {
            lock.unlock();
        }
    }

}

