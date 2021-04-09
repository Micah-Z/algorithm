package uf;

import uf.base.BaseUnionFind;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-04 16:21
 **/
public class WeightQuickUnionFind extends BaseUnionFind {

    // 各个结点的分量
    private int[] size;

    public WeightQuickUnionFind(int n) {
        super(n);
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = this.find(p);
        int qId = this.find(q);
        if (qId == pId){
            return;
        }
        // 将小的连通分量连到大的下面
        if (size[pId] < size[qId]){
            this.uf[pId] = qId;
            size[qId] += size[pId];
        }else {
            this.uf[qId] = pId;
            size[pId] += qId;
        }
        this.count--;
    }

    @Override
    public int find(int p) {
        while (p != this.uf[p]){
            p = this.uf[p];
        }
        return p;
    }
}
