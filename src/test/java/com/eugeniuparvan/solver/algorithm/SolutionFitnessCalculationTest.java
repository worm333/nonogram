package com.eugeniuparvan.solver.algorithm;

import org.junit.Assert;
import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Population;

public class SolutionFitnessCalculationTest extends NonogramTest
{
    @Test
    public void fitnessCalculation()
    {
	Population<Integer> population = getPopulation(nonogram, 1);
	Assert.assertFalse(population.hasBestIndividual());
    }
}
