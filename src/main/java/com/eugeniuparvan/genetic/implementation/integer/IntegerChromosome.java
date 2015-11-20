package com.eugeniuparvan.genetic.implementation.integer;

import java.util.ArrayList;
import java.util.List;

import com.eugeniuparvan.genetic.defenition.Chromosome;

public class IntegerChromosome implements Chromosome<Integer>
{
    private List<List<Integer>> genes;

    public IntegerChromosome()
    {
	this.genes = new ArrayList<List<Integer>>();
    }

    @Override
    public List<List<Integer>> getGenes()
    {
	return genes;
    }

}
