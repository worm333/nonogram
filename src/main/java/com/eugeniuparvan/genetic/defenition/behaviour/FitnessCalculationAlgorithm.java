package com.eugeniuparvan.genetic.defenition.behaviour;

import com.eugeniuparvan.genetic.defenition.Population;

public interface FitnessCalculationAlgorithm<C>
{
    public void calculateFitness(Population<C> population);
}
