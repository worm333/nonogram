package com.eugeniuparvan.solver.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Chromosome;
import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.implementation.integer.IntegerChromosome;
import com.eugeniuparvan.genetic.implementation.integer.IntegerIndividual;
import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.solver.SolutionFitness;

@Component
public class SolutionFactory implements IndividualFactory<Integer>
{
    private INonogram nonogram;

    @Autowired
    public SolutionFactory(INonogram nonogram)
    {
	this.nonogram = nonogram;
    }

    @Override
    public Individual<Integer> getIndividual()
    {
	return new IntegerIndividual(new SolutionFitness(), getChromosome());
    }

    private Chromosome<Integer> getChromosome()
    {
	Chromosome<Integer> chromosome = new IntegerChromosome();
	for (int j = 0; j < nonogram.getWidth(); ++j)
	{
	    List<Integer> gene = new ArrayList<Integer>();
	    for (int i = 0; i < nonogram.getHeight(); ++i)
	    {
		if (i == 0)
		{
		    for (Integer integer : nonogram.getTopNumberCollection().get(j))
		    {
			for (int x = 0; x < integer; ++x)
			{
			    gene.add(1);
			}
			if (gene.size() < nonogram.getHeight())
			{
			    gene.add(0);
			}
		    }
		    i = gene.size() - 1;
		}
		else
		{
		    gene.add(0);
		}
	    }
	    chromosome.getGenes().add(gene);
	}
	return chromosome;
    }

}
