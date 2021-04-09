package uf.main;

import uf.CommonUnionFind;
import uf.QuickUnionFind;
import uf.WeightQuickUnionFind;
import uf.base.BaseUnionFind;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-04 16:37
 **/
public class UnionFindMain {
    public static void main(String[] args) {
        // BaseUnionFind unionFind = new CommonUnionFind(9);
        // BaseUnionFind unionFind = new QuickUnionFind(9);
        BaseUnionFind unionFind = new WeightQuickUnionFind(9);
        unionFind.union(2,3);
        unionFind.union(1,2);
        unionFind.union(4,3);
        unionFind.union(6,8);
        System.out.println(Arrays.toString(unionFind.getUf()));
    }
}
