package uf.base;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-04-04 15:51
 **/
public abstract class BaseUnionFind {

    protected int[] uf;

    protected int count; // 连通分量的数量

    public BaseUnionFind(int n) {
        this.uf = new int[n];
        this.count = n;
        // 初始化
        for (int i = 0; i < n; i++) {
            this.uf[i] = i;
        }
    }

    public int[] getUf() {
        return uf;
    }

    public void setUf(int[] uf) {
        this.uf = uf;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public abstract void union(int p , int q);

    public abstract int find(int p);

    public boolean isConnected(int p , int q){
        return this.uf[p] == this.uf[q];
    }

}
