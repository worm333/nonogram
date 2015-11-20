package com.eugeniuparvan.genetic.implementation;

import com.eugeniuparvan.genetic.defenition.Engine;
import com.eugeniuparvan.genetic.defenition.EngineBuilder;
import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.behaviour.FitnessCalculationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.MutationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.ReproductionAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.SelectionAlgorithm;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.defenition.factory.PopulationFactory;

public abstract class GeneticEngine<C> implements Engine<C>
{
    protected final int populationSize;
    protected final int maxGeneration;
    protected final float mutationPersentage;

    protected final IndividualFactory<C> individualFactory;
    protected final PopulationFactory<C> populationFactory;
    protected final FitnessCalculationAlgorithm<C> fitnessCalculationAlgorithm;
    protected final RandomAlgorithm<C> randomAlgorithm;
    protected final SelectionAlgorithm<C> selectionAlgorithm;
    protected final ReproductionAlgorithm<C> reproductionAlgorithm;
    protected final MutationAlgorithm<C> mutationAlgorithm;

    protected Population<C> population;
    protected Individual<C> bestIndividual;

    public GeneticEngine(EngineBuilder<C> engineBuilder)
    {
	this.populationSize = engineBuilder.getPopulationSize();
	this.maxGeneration = engineBuilder.getMaxGeneration();
	this.mutationPersentage = engineBuilder.getMutationPersentage();

	this.individualFactory = engineBuilder.getIndividualFactory();
	if (individualFactory == null)
	    throw new NullPointerException();
	this.populationFactory = engineBuilder.getPopulationFactory();
	if (populationFactory == null)
	    throw new NullPointerException();
	this.fitnessCalculationAlgorithm = engineBuilder.getFitnessCalculationAlgorithm();
	if (fitnessCalculationAlgorithm == null)
	    throw new NullPointerException();
	this.randomAlgorithm = engineBuilder.getRandomAlgorithm();
	if (randomAlgorithm == null)
	    throw new NullPointerException();
	this.selectionAlgorithm = engineBuilder.getSelectionAlgorithm();
	if (selectionAlgorithm == null)
	    throw new NullPointerException();
	this.reproductionAlgorithm = engineBuilder.getReproductionAlgorithm();
	if (reproductionAlgorithm == null)
	    throw new NullPointerException();
	this.mutationAlgorithm = engineBuilder.getMutationAlgorithm();
	if (mutationAlgorithm == null)
	    throw new NullPointerException();
    }

    @Override
    public Individual<C> getBestIndividual()
    {
	return bestIndividual;
    }

    @Override
    public final void exec()
    {
	Population<C> population = initPopulation();
	if (population.hasBestIndividual())
	    bestIndividual = population.getBestIndividual();
	else
	    loop();
    }

    protected Population<C> initPopulation()
    {
	population = populationFactory.getPopulation(individualFactory, populationSize);
	for (Individual<C> individual : population.getIndividuals())
	{
	    randomAlgorithm.randomize(individual);
	}
	fitnessCalculationAlgorithm.calculateFitness(population);
	return population;
    }

    protected abstract Population<C> generateNextPopulation();

    private void loop()
    {
	for (int i = 0; i < maxGeneration; ++i)
	{
	    generateNextPopulation();

	    if (population.hasBestIndividual())
	    {
		bestIndividual = population.getBestIndividual();
		break;
	    }
	}
    }

}
