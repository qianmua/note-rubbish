package _LRU_;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
  description :

  @author mu.qian
  @date 2021/9/15  17:23

*/public class LRU {

    static class LRULinkedHashMap<K , V> extends LinkedHashMap<K , V> {

        private final int maxCapacity;
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private final Lock lock = new ReentrantLock();

        LRULinkedHashMap(int maxCapacity) {
            super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
            this.maxCapacity = maxCapacity;
        }

        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
            return size() > maxCapacity;
        }

        @Override
        public boolean containsKey(Object key) {
            try {
                lock.lock();
                return super.containsKey(key);
            } finally {
                lock.unlock();
            }
        }


        @Override
        public V get(Object key) {
            try {
                lock.lock();
                return super.get(key);
            } finally {
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

        public int size() {
            try {
                lock.lock();
                return super.size();
            } finally {
                lock.unlock();
            }
        }

        public void clear() {
            try {
                lock.lock();
                super.clear();
            } finally {
                lock.unlock();
            }
        }

        public Collection<Map.Entry<K, V>> getAll() {
            try {
                lock.lock();
                return new ArrayList<>(super.entrySet());
            } finally {
                lock.unlock();
            }
        }
    }

    static class LRUCache<K , V> {
        private int currentCacheSize;
        private int cacheCapacity;// 容量
        private HashMap<K , CacheNode> caches;
        private CacheNode first;
        private CacheNode last;

        public LRUCache(int size) {
            currentCacheSize = 0;
            this.cacheCapacity = size;
            caches = new HashMap<>(size);
        }

        public void put(K k, V v) {
            CacheNode cacheNode = caches.get(k);
            if (Objects.isNull(cacheNode)) {
                if (caches.size() >= cacheCapacity) {
                    // remove last
                    caches.remove(last.key);
                    removeLast();
                }
                cacheNode = new CacheNode();
                cacheNode.key = k;
            }
            cacheNode.value = v;
            // move first
            moveToFirst(cacheNode);
            caches.put(k , cacheNode);
        }

        public CacheNode get(K k) {
            CacheNode cacheNode = caches.get(k);
            if (Objects.isNull(cacheNode))
                return null;
            return cacheNode;
        }

        public CacheNode remove(K k) {
            CacheNode node = caches.get(k);
            if(node != null){
                if(node.pre != null){
                    node.pre.next=node.next;
                }
                if(node.next != null){
                    node.next.pre=node.pre;
                }
                if(node == first){
                    first = node.next;
                }
                if(node == last){
                    last = node.pre;
                }
            }
            return caches.remove(k);
        }

        public void clear(){
            first = null;
            last = null;
            caches.clear();
        }

        private void moveToFirst(CacheNode node) {
            if(first == node){
                return;
            }
            if(node.next != null){
                node.next.pre = node.pre;
            }
            if(node.pre != null){
                node.pre.next = node.next;
            }
            if(node == last){
                last= last.pre;
            }
            if(first == null || last == null){
                first = last = node;
                return;
            }

            node.next=first;
            first.pre = node;
            first = node;
            first.pre=null;
        }

        private void removeLast() {
            if (Objects.nonNull(last)) {
                last = last.pre;
                if (Objects.isNull(last)) {
                    first =null;
                }else {
                    last.next = null;
                }
            }
        }


        class CacheNode{
            CacheNode pre;
            CacheNode next;
            Object key;
            Object value;
            public CacheNode(){ }
        }
    }



}
