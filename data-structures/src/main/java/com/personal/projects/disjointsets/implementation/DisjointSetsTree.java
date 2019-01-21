package com.personal.projects.disjointsets.implementation;

import com.personal.projects.disjointsets.DisjointSets;

public class DisjointSetsTree implements DisjointSets {

    private int[] parent;
    private int[] rank;
    private int size;

    public DisjointSetsTree(int size) {

        this.parent = new int[size + 1];
        this.rank = new int[size + 1];
        this.size = size;

        for (int index = 0; index < this.size; ++index) {
            this.parent[index] = 0;
        }
    }

    @Override
    public void makeSet(int x) {

        if (elementOutOfRange(x)) {
            throw new IndexOutOfBoundsException("The element is out of range!");
        }

        this.parent[x] = x;
        this.rank[x] = 0;
    }

    @Override
    public int find(int x) {
        
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    @Override
    public void union(int x, int y) {

        int xId = find(x);
        int yId = find(y);

        if (xId == yId) {
            return;
        }

        if (rank[xId] > rank[yId]) {
            parent[yId] = xId;
        }
        else {
            parent[xId] = yId;
            if (rank[xId] == rank[yId]) {
                rank[yId]++;
            }
        }
    }

    private boolean elementOutOfRange(int x) {
        return x < 1 && x > size;
    }
}