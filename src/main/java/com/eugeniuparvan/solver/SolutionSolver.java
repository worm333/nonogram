package com.eugeniuparvan.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eugeniuparvan.genetic.defenition.EngineBuilder;
import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.implementation.GeneticEngine;

public class SolutionSolver extends GeneticEngine<Integer>
{
    private float error = 0;
    private int sameErrorCount = 0;

    public SolutionSolver(EngineBuilder<Integer> engineBuilder)
    {
	super(engineBuilder);
    }

    @Override
    protected Population<Integer> generateNextPopulation()
    {
	List<Individual<Integer>> individuals = new ArrayList<Individual<Integer>>();
	Map<Integer, List<Individual<Integer>>> parentsMap = selectionAlgorithm.select(population);
	float bestError = population.getIndividuals().get(0).getFitness().getValue();
	System.out.println(bestError + ":" + sameErrorCount);
	for (List<Individual<Integer>> parents : parentsMap.values())
	{
	    List<Individual<Integer>> childs = reproductionAlgorithm.reproduce(parents);
	    individuals.addAll(childs);
	}
	population.getIndividuals().clear();
	population.getIndividuals().addAll(individuals);
	fitnessCalculationAlgorithm.calculateFitness(population);
	if (error == bestError)
	{
	    sameErrorCount++;
	    if (sameErrorCount > 4)
		mutationAlgorithm.mutate(population, 100f);
	}
	else
	{
	    sameErrorCount = 0;
	}
	error = bestError;
	return population;
    }
}
