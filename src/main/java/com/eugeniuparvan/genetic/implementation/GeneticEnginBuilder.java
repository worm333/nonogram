package com.eugeniuparvan.genetic.implementation;

import com.eugeniuparvan.genetic.defenition.EngineBuilder;
import com.eugeniuparvan.genetic.defenition.behaviour.FitnessCalculationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.MutationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.ReproductionAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.SelectionAlgorithm;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.defenition.factory.PopulationFactory;

public class GeneticEnginBuilder<C> implements EngineBuilder<C>
{
    private int populationSize;
    private int maxGeneration;
    private float mutationPersentage;

    private IndividualFactory<C> individualFactory;
    private PopulationFactory<C> populationFactory;
    private FitnessCalculationAlgorithm<C> fitnessCalculationAlgorithm;
    private RandomAlgorithm<C> randomAlgorithm;
    private SelectionAlgorithm<C> selectionAlgorithm;
    private ReproductionAlgorithm<C> reproductionAlgorithm;
    private MutationAlgorithm<C> mutationAlgorithm;

    private GeneticEnginBuilder()
    {
    }

    public static <T> GeneticEnginBuilder<T> build()
    {
	return new GeneticEnginBuilder<T>();
    }

    @Override
    public int getPopulationSize()
    {
	return populationSize;
    }

    @Override
    public EngineBuilder<C> withPopulationSize(int populationSize)
    {
	this.populationSize = populationSize;
	return this;
    }

    @Override
    public int getMaxGeneration()
    {
	return maxGeneration;
    }

    @Override
    public EngineBuilder<C> withMaxGeneration(int maxGeneration)
    {
	this.maxGeneration = maxGeneration;
	return this;
    }

    @Override
    public float getMutationPersentage()
    {
	return mutationPersentage;
    }

    @Override
    public EngineBuilder<C> withMutationPersentage(float mutationPersentage)
    {
	this.mutationPersentage = mutationPersentage;
	return this;
    }

    @Override
    public IndividualFactory<C> getIndividualFactory()
    {
	return individualFactory;
    }

    @Override
    public EngineBuilder<C> withIndividualFactory(IndividualFactory<C> individualFactory)
    {
	this.individualFactory = individualFactory;
	return this;
    }

    @Override
    public PopulationFactory<C> getPopulationFactory()
    {
	return populationFactory;
    }

    @Override
    public EngineBuilder<C> withPopulationFactory(PopulationFactory<C> populationFactory)
    {
	this.populationFactory = populationFactory;
	return this;
    }

    @Override
    public FitnessCalculationAlgorithm<C> getFitnessCalculationAlgorithm()
    {
	return fitnessCalculationAlgorithm;
    }

    @Override
    public EngineBuilder<C> withFitnessCalculationAlgorithm(FitnessCalculationAlgorithm<C> fitnessCalculationAlgorithm)
    {
	this.fitnessCalculationAlgorithm = fitnessCalculationAlgorithm;
	return this;
    }

    @Override
    public RandomAlgorithm<C> getRandomAlgorithm()
    {
	return randomAlgorithm;
    }

    @Override
    public EngineBuilder<C> withRandomAlgorithm(RandomAlgorithm<C> randomAlgorithm)
    {
	this.randomAlgorithm = randomAlgorithm;
	return this;
    }

    @Override
    public ReproductionAlgorithm<C> getReproductionAlgorithm()
    {
	return reproductionAlgorithm;
    }

    @Override
    public EngineBuilder<C> withReproductionAlgorithm(ReproductionAlgorithm<C> reproductionAlgorithm)
    {
	this.reproductionAlgorithm = reproductionAlgorithm;
	return this;
    }

    @Override
    public SelectionAlgorithm<C> getSelectionAlgorithm()
    {
	return selectionAlgorithm;
    }

    @Override
    public EngineBuilder<C> withSelectionAlgorithm(SelectionAlgorithm<C> selectionAlgorithm)
    {
	this.selectionAlgorithm = selectionAlgorithm;
	return this;
    }

    @Override
    public MutationAlgorithm<C> getMutationAlgorithm()
    {
	return mutationAlgorithm;
    }

    @Override
    public EngineBuilder<C> withMutationAlgorithm(MutationAlgorithm<C> mutationAlgorithm)
    {
	this.mutationAlgorithm = mutationAlgorithm;
	return this;
    }

}
