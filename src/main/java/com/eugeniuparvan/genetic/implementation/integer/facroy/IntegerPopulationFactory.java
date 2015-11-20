package com.eugeniuparvan.genetic.implementation.integer.facroy;

import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.defenition.factory.PopulationFactory;
import com.eugeniuparvan.genetic.implementation.integer.IntegerPopulation;

public class IntegerPopulationFactory implements PopulationFactory<Integer>
{
    @Override
    public Population<Integer> getPopulation(IndividualFactory<Integer> individualFactory, int populationSize)
    {
	Population<Integer> population = new IntegerPopulation();

	for (int i = 0; i < populationSize; ++i)
	{
	    population.add(individualFactory.getIndividual());
	}
	return population;
    }
}
