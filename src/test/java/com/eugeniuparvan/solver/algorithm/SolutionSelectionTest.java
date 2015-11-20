package com.eugeniuparvan.solver.algorithm;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Individual;

public class SolutionSelectionTest extends NonogramTest
{
    @Test
    public void selection()
    {
	int populationSize = nonogram.getWidth() * nonogram.getHeight() / 2;
	Map<Integer, List<Individual<Integer>>> parentsMap = performSelection(nonogram, populationSize);
	Assert.assertEquals(parentsMap.size(), populationSize);
    }
}
