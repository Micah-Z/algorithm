package uf;

import uf.base.BaseUnionFind;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-04 15:59
 **/
public class CommonUnionFind extends BaseUnionFind {

    public CommonUnionFind(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        if (this.isConnected(p,q)){
            return;
        }
        int pId = this.uf[p];
        int qId = this.uf[q];
        // 遍历数组改变所有的与pId相同的值,时间复杂度很高
        for (int i = 0; i < this.uf.length; i++) {
            if (pId == this.uf[i]){
                this.uf[i] = qId;
            }
        }
        this.count--;
    }

    @Override
    public int find(int p) {
        return this.uf[p];
    }
}
