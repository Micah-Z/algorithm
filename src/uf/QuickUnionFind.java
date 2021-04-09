package uf;

import uf.base.BaseUnionFind;

/**
 * @program: leetcode
 * @description: 直接找到根节点修改根节点的值,这样做避免了二次遍历,不过这样做的话大的树会连到小的树上面,到最后找到根节点越来越难
 * @author: Micah
 * @create: 2021-04-04 16:13
 **/
public class QuickUnionFind extends BaseUnionFind {

    public QuickUnionFind(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        // p的根节点的值
        int pId = this.find(p);
        // q的根节点的值
        int qId = this.find(q);
        if (pId == qId){
            return;
        }
        this.uf[pId] = qId;
        this.count--;

    }

    @Override
    public int find(int p) {
        // 找到根节点
        while (p != this.uf[p]){
            p = this.uf[p];
        }
        return p;
    }
}
