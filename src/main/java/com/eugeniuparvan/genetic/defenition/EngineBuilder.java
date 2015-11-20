package com.eugeniuparvan.genetic.defenition;

import com.eugeniuparvan.genetic.defenition.behaviour.FitnessCalculationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.MutationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.ReproductionAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.SelectionAlgorithm;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.defenition.factory.PopulationFactory;

public interface EngineBuilder<C>
{
    public int getPopulationSize();

    public EngineBuilder<C> withPopulationSize(int populationSize);

    public int getMaxGeneration();

    public EngineBuilder<C> withMaxGeneration(int maxGeneration);

    public float getMutationPersentage();

    public EngineBuilder<C> withMutationPersentage(float mutationPersentage);

    public IndividualFactory<C> getIndividualFactory();

    public EngineBuilder<C> withIndividualFactory(IndividualFactory<C> individualFactory);

    public PopulationFactory<C> getPopulationFactory();

    public EngineBuilder<C> withPopulationFactory(PopulationFactory<C> populationFactory);

    public FitnessCalculationAlgorithm<C> getFitnessCalculationAlgorithm();

    public EngineBuilder<C> withFitnessCalculationAlgorithm(FitnessCalculationAlgorithm<C> fitnessCalculationAlgorithm);

    public RandomAlgorithm<C> getRandomAlgorithm();

    public EngineBuilder<C> withRandomAlgorithm(RandomAlgorithm<C> randomAlgorithm);

    public ReproductionAlgorithm<C> getReproductionAlgorithm();

    public EngineBuilder<C> withReproductionAlgorithm(ReproductionAlgorithm<C> reproductionAlgorithm);

    public SelectionAlgorithm<C> getSelectionAlgorithm();

    public EngineBuilder<C> withSelectionAlgorithm(SelectionAlgorithm<C> selectionAlgorithm);

    public MutationAlgorithm<C> getMutationAlgorithm();

    public EngineBuilder<C> withMutationAlgorithm(MutationAlgorithm<C> mutationAlgorithm);
}
