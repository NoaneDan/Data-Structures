package com.personal.projects.disjointsets;

public interface DisjointSets {

    public void makeSet(int x);
    public int find(int x);
    public void union(int x, int y);
}