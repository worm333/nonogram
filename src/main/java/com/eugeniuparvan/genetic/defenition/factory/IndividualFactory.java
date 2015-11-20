package com.eugeniuparvan.genetic.defenition.factory;

import com.eugeniuparvan.genetic.defenition.Individual;

public interface IndividualFactory<C>
{
    public Individual<C> getIndividual();
}
