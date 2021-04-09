package tree.main;

import tree.BinarySearchTree;
import tree.RedBlackTree;
import tree.base.BaseTree;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-03 17:25
 **/
public class TreeMain {
    public static void main(String[] args) {
        RedBlackTree<Integer,Integer> tree = new RedBlackTree<>();
        // BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<>();
        tree.put(1,5);
        tree.put(6,4);
        tree.put(3,8);
        tree.put(9,2);
        tree.put(5,6);
        tree.put(0,3);
        tree.inOrder(tree.getRoot());
    }
}
