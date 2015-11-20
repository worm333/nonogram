package com.eugeniuparvan.solver.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Chromosome;
import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.behaviour.FitnessCalculationAlgorithm;
import com.eugeniuparvan.nonograms.defenition.INonogram;

@Component
public class SolutionFitnessCalculation implements FitnessCalculationAlgorithm<Integer>
{
    private INonogram nonogram;

    @Autowired
    public SolutionFitnessCalculation(INonogram nonogram)
    {
	this.nonogram = nonogram;
    }

    @Override
    public void calculateFitness(Population<Integer> population)
    {
	for (Individual<Integer> individual : population.getIndividuals())
	{
	    calculate(individual);
	}
    }

    protected final void calculate(Individual<Integer> individual)
    {
	int errorSum = 0;

	Chromosome<Integer> chromosome = individual.getChromosome();
	List<List<Integer>> genes = chromosome.getGenes();

	List<List<Integer>> leftNumbers = nonogram.getLeftNumberCollection();
	int rowCount = nonogram.getHeight();
	int columnCount = nonogram.getWidth();

	for (int i = 0; i < rowCount; ++i)
	{
	    List<Integer> row = leftNumbers.get(i);
	    List<Integer> chromosomeRow = new ArrayList<Integer>();
	    for (int j = 0; j < columnCount; ++j)
	    {
		chromosomeRow.add(genes.get(j).get(i));
	    }
	    errorSum += getRowError(row, chromosomeRow);
	}
	individual.getFitness().setValue(errorSum);
    }

    protected final int getRowError(List<Integer> row, List<Integer> chromosomeRow)
    {
	int nonogramColumnSum = 0;
	for (Integer value : row)
	{
	    nonogramColumnSum += value;
	}

	int geneValuesSum = 0;
	for (Integer value : chromosomeRow)
	{
	    geneValuesSum += value;
	}

	return Math.abs(geneValuesSum - nonogramColumnSum);
    }
}
