package com.eugeniuparvan.solver.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;
import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.solver.algorithm.utils.IRandomUtils;

@Component
public class SolutionRandom implements RandomAlgorithm<Integer>
{
    private INonogram nonogram;
    private IRandomUtils random;

    @Autowired
    public SolutionRandom(INonogram nonogram, IRandomUtils random)
    {
	this.nonogram = nonogram;
	this.random = random;
    }

    @Override
    public void randomize(Individual<Integer> individual)
    {
	List<List<Integer>> genes = individual.getChromosome().getGenes();
	for (int i = 0; i < genes.size(); ++i)
	{
	    randomizeGene(i, genes);
	}
    }

    public void randomizeGene(int geneIndex, List<List<Integer>> genes)
    {
	List<Integer> topNumbers = nonogram.getTopNumberCollection().get(geneIndex);
	int index = random.getRandomNumberInRange(0, topNumbers.size() - 1);
	int topGene = getTopBound(topNumbers, index);
	int bottomGene = getBottomBound(topNumbers, index);
	int randomIndex = random.getRandomNumberInRange(topGene, bottomGene);

	List<Integer> randomizedGene = blankGene(nonogram.getHeight());
	fillGene(randomIndex, randomIndex + topNumbers.get(index) - 1, randomizedGene);
	randomizeTop(randomizedGene, topNumbers, index, randomIndex);
	randomizeBottom(randomizedGene, topNumbers, index, randomIndex);
	genes.set(geneIndex, randomizedGene);
    }

    private List<Integer> blankGene(int size)
    {
	List<Integer> gene = new ArrayList<Integer>();
	for (int i = 0; i < size; ++i)
	{
	    gene.add(0);
	}
	return gene;
    }

    private void fillGene(int start, int end, List<Integer> gene)
    {
	for (int i = start; i <= end; ++i)
	{
	    gene.set(i, 1);
	}
    }

    private void randomizeTop(List<Integer> gene, List<Integer> topNumbers, int topNumberIndex, int geneIndex)
    {
	if (topNumberIndex == 0)
	    return;
	for (int i = topNumberIndex - 1; i >= 0; --i)
	{
	    int topGene = getTopBound(topNumbers, i);
	    int bottomGene = geneIndex - topNumbers.get(i) - 1;
	    geneIndex = random.getRandomNumberInRange(topGene, bottomGene);
	    fillGene(geneIndex, geneIndex + topNumbers.get(i) - 1, gene);
	}
    }

    private void randomizeBottom(List<Integer> gene, List<Integer> topNumbers, int topNumberIndex, int geneIndex)
    {
	if (topNumberIndex == topNumbers.size() - 1)
	    return;
	for (int i = topNumberIndex + 1; i < topNumbers.size(); ++i)
	{
	    int topGene = geneIndex + topNumbers.get(i - 1) + 1;
	    int bottomGene = getBottomBound(topNumbers, i);
	    geneIndex = random.getRandomNumberInRange(topGene, bottomGene);
	    fillGene(geneIndex, geneIndex + topNumbers.get(i) - 1, gene);
	}
    }

    private int getTopBound(List<Integer> topNumbers, int index)
    {
	if (index == 0)
	    return 0;
	int sum = 0;
	for (int i = 0; i < index; ++i)
	    sum += topNumbers.get(i) + 1;
	return sum;
    }

    private int getBottomBound(List<Integer> topNumbers, int index)
    {
	int height = nonogram.getHeight();
	if (index == topNumbers.size() - 1)
	    return height - topNumbers.get(index);
	int sum = 0;
	for (int i = topNumbers.size() - 1; i > index; --i)
	    sum += topNumbers.get(i) + 1;
	return height - sum - topNumbers.get(index);
    }

}
