package com.eugeniuparvan.solver.algorithm;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.behaviour.MutationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;

@Component
public class SolutionMutation implements MutationAlgorithm<Integer>
{
    private RandomAlgorithm<Integer> randomAlgorithm;

    @Autowired
    public SolutionMutation(RandomAlgorithm<Integer> randomAlgorithm)
    {
	this.randomAlgorithm = randomAlgorithm;
    }

    @Override
    public void mutate(Population<Integer> population, float mutationPersentage)
    {
	Collections.sort(population.getIndividuals(), new Comparator<Individual<Integer>>()
	{
	    @Override
	    public int compare(Individual<Integer> o1, Individual<Integer> o2)
	    {
		if (o1.getFitness().getValue() > o2.getFitness().getValue())
		    return 1;
		else if (o1.getFitness().getValue() == o2.getFitness().getValue())
		    return 0;
		else
		    return -1;
	    }
	});
	Individual<Integer> dominant = population.getIndividuals().get(0);
	double random = Math.random();
	if (random * 100 < mutationPersentage)
	{
	    randomAlgorithm.randomize(dominant);
	    System.out.println("Mutation");
	}
    }
}
