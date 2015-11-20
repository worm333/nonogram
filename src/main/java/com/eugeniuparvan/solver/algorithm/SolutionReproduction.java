package com.eugeniuparvan.solver.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.behaviour.ReproductionAlgorithm;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.solver.algorithm.utils.IRandomUtils;

@Component
public class SolutionReproduction implements ReproductionAlgorithm<Integer>
{
    private INonogram nonogram;

    private IndividualFactory<Integer> individualFactory;

    private IRandomUtils random;

    @Autowired
    public SolutionReproduction(INonogram nonogram, IndividualFactory<Integer> individualFactory, IRandomUtils random)
    {
	this.nonogram = nonogram;
	this.individualFactory = individualFactory;
	this.random = random;
    }

    @Override
    public List<Individual<Integer>> reproduce(List<Individual<Integer>> parents)
    {
	List<List<Integer>> firstParentGenes = getClonedGenes(parents.get(0).getChromosome().getGenes());
	List<List<Integer>> secondParentGenes = getClonedGenes(parents.get(1).getChromosome().getGenes());
	int randomIndex = random.getRandomNumberInRange(0, nonogram.getWidth() - 1);
	secondParentGenes.set(randomIndex, firstParentGenes.get(randomIndex));
	Individual<Integer> individual = individualFactory.getIndividual();
	individual.getChromosome().getGenes().clear();
	individual.getChromosome().getGenes().addAll(secondParentGenes);
	return Arrays.asList(individual);
    }

    private List<List<Integer>> getClonedGenes(List<List<Integer>> genes)
    {
	List<List<Integer>> clonedGenes = new ArrayList<List<Integer>>();
	for (List<Integer> gene : genes)
	{
	    List<Integer> clonedGene = new ArrayList<Integer>();
	    for (Integer e : gene)
	    {
		clonedGene.add(e);
	    }
	    clonedGenes.add(clonedGene);
	}
	return clonedGenes;
    }

}
