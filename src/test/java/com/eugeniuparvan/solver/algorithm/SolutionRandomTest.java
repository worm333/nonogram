package com.eugeniuparvan.solver.algorithm;

import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Individual;

public class SolutionRandomTest extends NonogramTest
{
    @Test
    public void random()
    {
	Individual<Integer> individual = getIndividual();
	for (int i = 0; i < 10; ++i)
	{
	    randomAlgorithm.randomize(individual);
	}
    }
}
