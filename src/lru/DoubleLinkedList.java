package lru;

import leetcode.editor.cn.datastruct.ListNode;

/**
 * @program: leetcode
 * @description: 双端链表
 * @author: Micah
 * @create: 2021-04-05 14:53
 **/
public class DoubleLinkedList<K,V> {

    private Node<K,V> head;

    private Node<K,V> tail;

    private int size;


    public void addFirst(Node<K,V> node){
        if (head == null){
            node.setNext(null);
            this.tail = node;
        }else {
            Node<K,V> temp = head;
            temp.setPrev(node);
            node.setNext(temp);
        }
        this.head = node;
        size++;
    }

    public Node<K,V> removeLast(){
        Node<K,V> last = this.tail;
        this.tail = this.tail.prev;
        this.tail.next = null;
        size--;
        return last;
    }

    public Node<K,V> remove(Node<K,V> node){
        if (this.head == node && this.tail == node){
            this.head = null;
            this.tail = null;
        }else if (this.head == node){
            this.head = node.next;
            this.head.prev = null;
        }else if (this.tail == node){
            this.tail = node.prev;
            this.tail.next = null;
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node;
    }

    public int size(){
        return this.size;
    }

    public Node<K, V> getHead() {
        return head;
    }

    static class Node<K,V>{
        private K key;

        private V value;

        private Node<K,V> prev;

        private Node<K,V> next;

        public Node(K key, V value, Node<K, V> prev, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, V> prev) {
            this.prev = prev;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
