package com.eugeniuparvan.genetic.implementation.integer;

import com.eugeniuparvan.genetic.defenition.Chromosome;
import com.eugeniuparvan.genetic.defenition.Fitness;
import com.eugeniuparvan.genetic.defenition.Individual;

public class IntegerIndividual implements Individual<Integer>
{
    private Fitness fitness;

    private Chromosome<Integer> chromosome;

    public IntegerIndividual(Fitness fitness, Chromosome<Integer> chromosome)
    {
	this.fitness = fitness;
	this.chromosome = chromosome;
    }

    @Override
    public Fitness getFitness()
    {
	return fitness;
    }

    @Override
    public Chromosome<Integer> getChromosome()
    {
	return chromosome;
    }

    @Override
    public String toString()
    {
	int width = chromosome.getGenes().size();
	int height = chromosome.getGenes().get(0).size();
	StringBuilder builder = new StringBuilder();
	for (int j = 0; j < height; ++j)
	{
	    for (int i = 0; i < width; ++i)
	    {
		int result = chromosome.getGenes().get(i).get(j);
		if (result == 0)
		    builder.append(" ");
		else
		    builder.append("#");
	    }
	    builder.append("\n");
	}
	return builder.toString();
    }

}
