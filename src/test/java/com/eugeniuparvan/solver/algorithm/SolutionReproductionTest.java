package com.eugeniuparvan.solver.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Individual;

public class SolutionReproductionTest extends NonogramTest
{
    @Test
    public void reproduction()
    {
	int populationSize = nonogram.getHeight() * nonogram.getWidth();
	Map<Integer, List<Individual<Integer>>> parentsMap = performSelection(nonogram, populationSize);

	List<Individual<Integer>> individuals = new ArrayList<Individual<Integer>>();
	for (List<Individual<Integer>> parents : parentsMap.values())
	{
	    individuals.addAll(reproductionAlgorithm.reproduce(parents));
	}
    }
}
