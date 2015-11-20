package com.eugeniuparvan.genetic.defenition;

import java.util.List;

public interface Population<C>
{
    public List<Individual<C>> getIndividuals();

    public int getSize();

    public void add(Individual<C> individual);

    public void addAll(List<Individual<C>> individuals);

    public boolean hasBestIndividual();

    public Individual<C> getBestIndividual();
}
