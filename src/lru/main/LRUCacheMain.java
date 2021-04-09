package lru.main;

import lru.LRUCache;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-05 15:40
 **/
public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache<String,Integer> cache = new LRUCache<>(3);
        cache.put("a",1);
        cache.put("b",2);
        cache.put("c",3);
        /*cache.put("d",4);
        cache.get("c");*/
        System.out.println(cache);
    }
}
