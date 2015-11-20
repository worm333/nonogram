package com.eugeniuparvan;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;
import com.eugeniuparvan.genetic.defenition.behaviour.FitnessCalculationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.MutationAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.RandomAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.ReproductionAlgorithm;
import com.eugeniuparvan.genetic.defenition.behaviour.SelectionAlgorithm;
import com.eugeniuparvan.genetic.defenition.factory.IndividualFactory;
import com.eugeniuparvan.genetic.implementation.integer.facroy.IntegerPopulationFactory;
import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.nonograms.defenition.INonogramFactory;
import com.eugeniuparvan.solver.algorithm.SolutionFitnessCalculation;
import com.eugeniuparvan.solver.algorithm.SolutionSelection;
import com.eugeniuparvan.solver.factory.SolutionFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =
{
	SpringTestConfig.class
})
public class NonogramTest
{
    @Autowired
    protected INonogram nonogram;
    @Autowired
    protected INonogramFactory nonogramFactory;
    @Autowired
    protected FitnessCalculationAlgorithm<Integer> fitnessCalculationAlgorithm;
    @Autowired
    protected RandomAlgorithm<Integer> randomAlgorithm;
    @Autowired
    protected MutationAlgorithm<Integer> mutationAlgorithm;
    @Autowired
    protected IndividualFactory<Integer> individualFactory;
    @Autowired
    protected ReproductionAlgorithm<Integer> reproductionAlgorithm;
    @Autowired
    protected SelectionAlgorithm<Integer> selectionAlgorithm;

    protected Map<Integer, List<Individual<Integer>>> performSelection(INonogram nonogram, int populationSize)
    {
	Population<Integer> population = getPopulation(nonogram, populationSize);
	SelectionAlgorithm<Integer> selection = new SolutionSelection();
	return selection.select(population);
    }

    protected Population<Integer> getPopulation(INonogram nonogram, int populationSize)
    {
	Population<Integer> population = new IntegerPopulationFactory().getPopulation(new SolutionFactory(nonogram),
		populationSize);
	for (Individual<Integer> individual : population.getIndividuals())
	    randomAlgorithm.randomize(individual);
	FitnessCalculationAlgorithm<Integer> fitnessCalculation = new SolutionFitnessCalculation(nonogram);
	fitnessCalculation.calculateFitness(population);
	return population;
    }

    protected Individual<Integer> getIndividual()
    {
	return individualFactory.getIndividual();
    }

}
