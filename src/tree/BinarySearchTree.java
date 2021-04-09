package tree;

import tree.base.BaseTree;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-03 16:50
 **/
public class BinarySearchTree<K extends Comparable<K>,V> extends BaseTree<K,V> {

    private Node<K,V> root;


    public Node<K, V> getRoot() {
        return root;
    }

    @Override
    public void put(K key, V value) {
        if (root == null){
            this.root = new Node<>(key,value,1);
        }else {
            put(root,key,value);
        }
    }

    private Node<K, V> put(Node<K, V> root, K key, V value) {
        if (root == null){
            return new Node<>(key,value,1);
        }
        int com = key.compareTo(root.getK());
        if (com < 0){
            // 挂在左边
            root.setLeft(put(root.getLeft(),key,value));
        }else if (com > 0){
            // 挂在右边
            root.setRight(put(root.getRight(),key,value));
        }else {
            // 覆盖值
            root.setV(value);
        }
        root.setCount(this.size(root.getLeft()) + this.size(root.getRight()) + 1);
        return root;
    }

    @Override
    public V get(K k) {
        return get(root,k);
    }

    private V get(Node<K, V> root, K key) {
        if (root == null){
            return null;
        }
        int com = key.compareTo(root.getK());
        if (com < 0){
            // 往左边递归查找
            this.get(root.getLeft(),key);
        }else if (com > 0){
            // 往右边递归查找
            this.get(root.getRight(),key);
        }else {
            return root.getV();
        }
        return null;
    }

    @Override
    public Node<K, V> delete(K k) {
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    protected int size(Node<K,V> node) {
        if (node == null){
            return 0;
        }
        return node.getCount();
    }

}
