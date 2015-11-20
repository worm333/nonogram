package com.eugeniuparvan.solver.factory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Individual;

public class SolutionFactoryTest extends NonogramTest
{
    @Test
    public void getSolution()
    {
	Individual<Integer> individual = getIndividual();

	for (List<Integer> gene : individual.getChromosome().getGenes())
	{
	    Assert.assertEquals(10, gene.size());
	}
    }
}
