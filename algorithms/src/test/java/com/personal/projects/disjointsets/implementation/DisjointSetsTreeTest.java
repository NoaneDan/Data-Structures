package com.personal.projects.disjointsets.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.personal.projects.disjointsets.DisjointSets;

import org.junit.Before;
import org.junit.Test;

public class DisjointSetsTreeTest {

    private DisjointSets disjointSets;

    @Before
    public void setUp() {
        disjointSets = new DisjointSetsTree(3);
    }

    @Test
    public void testDisjointSets() {

        disjointSets.makeSet(1);
        disjointSets.makeSet(3);

        assertNotEquals(disjointSets.find(1), disjointSets.find(3));
        
        disjointSets.makeSet(2);
        disjointSets.union(1, 2);

        assertNotEquals(disjointSets.find(1), disjointSets.find(3));
        assertNotEquals(disjointSets.find(2), disjointSets.find(3));
        assertEquals(disjointSets.find(1), disjointSets.find(2));
    }
}