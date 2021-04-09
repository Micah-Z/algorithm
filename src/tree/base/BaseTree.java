package tree.base;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-03 16:36
 **/
public abstract class BaseTree<K extends Comparable<K>, V> {

    public abstract void put(K key,V value);

    public abstract V get(K k);

    public abstract Node<K,V> delete(K k);

    public abstract int size();

    public void inOrder(Node<K,V> root){
        if (root == null){
            return;
        }
        this.inOrder(root.getLeft());
        System.out.println(root.getK());
        this.inOrder(root.getRight());
    }


    public static class Node<K, V> {
        private K k;
        private V v;
        private Node<K,V> left;
        private Node<K,V> right;
        private int count;

        public Node(K k, V v, Node<K, V> left, Node<K, V> right,int count) {
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
            this.count = count;
        }

        public Node(K k, V v,int count) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.count = count;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
