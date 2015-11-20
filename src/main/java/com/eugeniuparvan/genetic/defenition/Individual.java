package com.eugeniuparvan.genetic.defenition;

public interface Individual<C>
{
    public Fitness getFitness();

    public Chromosome<C> getChromosome();

    public String toString();
}
