/*
 * (C) Copyright 2017-2018, by Dimitrios Michail and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
package org.jgrapht.alg.color;

import org.jgrapht.*;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm.*;
import org.jgrapht.graph.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Coloring tests
 * 
 * @author Dimitrios Michail
 */
public class GreedyColoringTest
    extends
    BaseColoringTest
{

    @Override
    protected VertexColoringAlgorithm<Integer> getAlgorithm(Graph<Integer, DefaultEdge> graph)
    {
        return new GreedyColoring<>(graph);
    }

    @Override
    protected int getExpectedResultOnDSaturNonOptimalGraph()
    {
        return 4;
    }

    @Test
    public void testGreedy()
    {
        Graph<Integer, DefaultEdge> g = createGraph1();

        Coloring<Integer> coloring = new GreedyColoring<>(g).getColoring();
        assertEquals(3, coloring.getNumberColors());
        Map<Integer, Integer> colors = coloring.getColors();
        assertEquals(0, colors.get(1).intValue());
        assertEquals(1, colors.get(2).intValue());
        assertEquals(2, colors.get(3).intValue());
        assertEquals(1, colors.get(4).intValue());
        assertEquals(1, colors.get(5).intValue());
    }

}
