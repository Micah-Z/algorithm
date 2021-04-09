package tree;

import tree.base.BaseTree;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-03 17:42
 **/
public class RedBlackTree<K extends Comparable<K>,V> extends BinarySearchTree<K,V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private RedBlackNode<K,V> root;

    @Override
    public RedBlackNode<K, V> getRoot() {
        return root;
    }

    @Override
    public void put(K key, V value) {
        RedBlackNode<K,V> node = null;
        if (this.root == null){
             node = new RedBlackNode<>(key, value, 1, BLACK);

        }else {
            node= putVal(this.root, key, value);
            node.setColor(BLACK);
        }
        // 这里要覆盖根节点,根节点在旋转后已经发生了变化了
        this.root = node;
    }

    private RedBlackNode<K,V> putVal(RedBlackNode<K, V> root, K key, V value) {
        if (root == null){
            return new RedBlackNode<>(key, value, 1, RED);
        }
        int com = key.compareTo(root.getK());
        if (com < 0){
            // 往左边插入
            root.setLeft(putVal(root.getLeft(),key,value));
        }else if (com > 0){
            // 往右边插入
            root.setRight(putVal(root.getRight(),key,value));
        }else {
            // 更新值
            root.setV(value);
        }
        // 对树进行旋转操作
        // 右边是红色的,往左旋转
        if (this.isRed(root.getRight()) && !this.isRed(root.getLeft())){
            root = this.rotateLeft(root);
        }
        // 左边连续是红色的,往右旋转
        if (this.isRed(root.getLeft()) && this.isRed(root.getLeft().getLeft())){
            root = this.rotateRight(root);
        }
        // 左右都是红色的,进行颜色转换
        if (this.isRed(root.getLeft()) && this.isRed(root.getRight())){
            this.filpColors(root);
        }
        root.setCount(size(root.getLeft()) + size(root.getRight()) + 1);
        return root;
    }


    @Override
    public V get(K k) {
        return super.get(k);
    }

    @Override
    public Node<K, V> delete(K k) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


    private static class RedBlackNode<K,V> extends BaseTree.Node<K,V>{
        private boolean color;

        public RedBlackNode(K k, V v, int count,boolean color) {
            super(k, v, count);
            this.color = color;
        }

        @Override
        public RedBlackNode<K, V> getLeft() {
            return (RedBlackNode<K, V>)super.getLeft();
        }

        @Override
        public RedBlackNode<K, V> getRight() {
            return (RedBlackNode<K, V>)super.getRight();
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

    }

    public boolean isRed(RedBlackNode<K, V> node){
        return node != null && node.getColor();
    }

    /**
     * 左旋,将当前的结点变为当前结点的右结点的左结点,然后当前的结点的右节点的左结点变为当前结点的右结点
     *     A                                    C
     *    / \                                  / \
     *   B   C              ----->            A   E
     *      / \                              / \
     *     D   E                            B   D
     * @param node
     * @return
     */
    private RedBlackNode<K,V> rotateLeft(RedBlackNode<K,V> node){
        // 获取右子结点
        RedBlackNode<K, V> newRoot = node.getRight();
        // 当前的结点的右子结点设置为右子结点的左子结点,因为这个左子结点相当于3-树中的那个中间结点
        node.setRight(newRoot.getLeft());
        // 当前的结点变为右子节点的左子节点
        newRoot.setLeft(node);
        // 此时右子节点变为了当前节点的父节点,更新颜色
        newRoot.setColor(node.getColor());

        // 旋转后node到下面去了设为红色
        node.setColor(RED);
        // 更新子结点数量
        newRoot.setCount(node.getCount());
        node.setCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return newRoot;
    }

    /**
     * 右旋
     *         A                                C
     *        / \                              / \
     *       C   D                   ---->    E   A
     *      / \                                  / \
     *     E   F                                F   D
     * @param node
     * @return
     */
    private RedBlackNode<K,V> rotateRight(RedBlackNode<K,V> node){
        // 获取左子结点
        RedBlackNode<K,V> newRoot = node.getLeft();
        // 移动左子结点的右节点到node的左子节点
        node.setLeft(newRoot.getRight());
        // 将node的左子节点的右子节点设置为当前节点,这样newRoot就变为了新的根节点了
        newRoot.setRight(node);
        // 更新颜色
        newRoot.setColor(node.getColor());
        // 此时需要更新node的颜色为红色
        node.setColor(RED);
        // 更新结点的数量
        newRoot.setCount(node.getCount());
        node.setCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return newRoot;
    }

    /**
     * 在红黑树中只能左边结点被红色链接,如果左右都被红色链接此时转换成黑色链接
     * @param node
     */
    private void filpColors(RedBlackNode<K,V> node){
        node.getRight().setColor(BLACK);
        node.getLeft().setColor(BLACK);
        node.setColor(RED);
    }
}
