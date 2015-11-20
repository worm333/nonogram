package com.eugeniuparvan.solver.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.behaviour.SelectionAlgorithm;

@Component
public class SolutionSelection implements SelectionAlgorithm<Integer>
{
    @Override
    public Map<Integer, List<Individual<Integer>>> select(Population<Integer> population)
    {
	Collections.sort(population.getIndividuals(), new Comparator<Individual<Integer>>()
	{
	    @Override
	    public int compare(Individual<Integer> o1, Individual<Integer> o2)
	    {
		if (o1.getFitness().getValue() > o2.getFitness().getValue())
		    return 1;
		else if (o1.getFitness().getValue() == o2.getFitness().getValue())
		    return 0;
		else
		    return -1;
	    }
	});
	Map<Integer, List<Individual<Integer>>> parentsMap = new HashMap<Integer, List<Individual<Integer>>>();
	List<Individual<Integer>> bestIndividuals = getBestIndividuals(population);
	int index = 0;
	int populationSize = population.getSize();
	for (int i = 0; i < populationSize; ++i)
	{
	    Individual<Integer> firstIndividual = bestIndividuals.get(index);
	    Individual<Integer> secondIndividual = population.getIndividuals().get(i);
	    parentsMap.put(i, Arrays.asList(firstIndividual, secondIndividual));
	}
	return parentsMap;
    }

    private List<Individual<Integer>> getBestIndividuals(Population<Integer> sortedPopulation)
    {
	List<Individual<Integer>> individuals = sortedPopulation.getIndividuals();
	Individual<Integer> firstIndividual = individuals.get(0);
	List<Individual<Integer>> best = new ArrayList<Individual<Integer>>();
	best.add(firstIndividual);
	float error = firstIndividual.getFitness().getValue();
	for (int i = 1; i < sortedPopulation.getIndividuals().size(); ++i)
	{
	    Individual<Integer> individual = individuals.get(i);
	    if (individual.getFitness().getValue() > error)
		break;
	    best.add(individual);
	}
	return best;
    }

}
