package com.eugeniuparvan.genetic.defenition.factory;

import com.eugeniuparvan.genetic.defenition.Population;

public interface PopulationFactory<C>
{
    public Population<C> getPopulation(IndividualFactory<C> individualFactory, int populationSize);
}
