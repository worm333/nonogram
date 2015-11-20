package com.eugeniuparvan.genetic.defenition.behaviour;

import com.eugeniuparvan.genetic.defenition.Population;

public interface MutationAlgorithm<C>
{
    public void mutate(Population<C> population, float mutationPersentage);
}
