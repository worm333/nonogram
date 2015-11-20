package com.eugeniuparvan.genetic.implementation.integer;

import java.util.ArrayList;
import java.util.List;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;

public class IntegerPopulation implements Population<Integer>
{
    private List<Individual<Integer>> individuals;

    public IntegerPopulation()
    {
	this.individuals = new ArrayList<Individual<Integer>>();
    }

    @Override
    public List<Individual<Integer>> getIndividuals()
    {
	return individuals;
    }

    @Override
    public int getSize()
    {
	return individuals.size();
    }

    @Override
    public void add(Individual<Integer> individual)
    {
	individuals.add(individual);
    }

    @Override
    public void addAll(List<Individual<Integer>> individuals)
    {
	individuals.addAll(individuals);
    }

    @Override
    public boolean hasBestIndividual()
    {
	for (Individual<Integer> individual : individuals)
	{
	    if (individual.getFitness().isBest())
		return true;
	}
	return false;
    }

    @Override
    public Individual<Integer> getBestIndividual()
    {
	for (Individual<Integer> individual : individuals)
	{
	    if (individual.getFitness().isBest())
		return individual;
	}
	return null;
    }

}
