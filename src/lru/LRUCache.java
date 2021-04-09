package lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-05 15:18
 **/
public class LRUCache<K, V> {

    private Map<K, DoubleLinkedList.Node<K, V>> map;

    private DoubleLinkedList<K, V> doubleLinkedList;

    private int size;

    public LRUCache(int size) {
        this.size = size;
        map = new HashMap<>(size);
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        DoubleLinkedList.Node<K, V> node = map.get(key);
        doubleLinkedList.remove(node);
        doubleLinkedList.addFirst(node);
        return node.getValue();
    }

    public void put(K key, V value) {
        DoubleLinkedList.Node<K,V> node = new DoubleLinkedList.Node<>(key,value,null,null);
        if (doubleLinkedList.size() >= size){
            DoubleLinkedList.Node<K, V> last = doubleLinkedList.removeLast();
            map.remove(last.getKey());
        }
        map.put(key,node);
        doubleLinkedList.addFirst(node);
    }

    @Override
    public String toString() {
        DoubleLinkedList.Node<K, V> head = doubleLinkedList.getHead();
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.getKey()).append(":").append(head.getValue()).append("\r\n");
            head = head.getNext();
        }
        return sb.toString();
    }
}
