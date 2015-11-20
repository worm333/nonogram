package com.eugeniuparvan.solver;

import org.junit.Assert;
import org.junit.Test;

import com.eugeniuparvan.NonogramTest;
import com.eugeniuparvan.genetic.defenition.Engine;
import com.eugeniuparvan.genetic.defenition.EngineBuilder;
import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.implementation.GeneticEnginBuilder;
import com.eugeniuparvan.genetic.implementation.integer.facroy.IntegerPopulationFactory;

public class SolverTest extends NonogramTest
{
    @Test
    public void solve()
    {
	int maxGeneration = 100000;
	int populationSize = nonogram.getWidth() * nonogram.getWidth();
	float mutationPersentage = 5f;

	EngineBuilder<Integer> engineBuilder = GeneticEnginBuilder.<Integer> build().withMaxGeneration(maxGeneration)
		.withPopulationSize(populationSize).withMutationPersentage(mutationPersentage)
		.withIndividualFactory(individualFactory).withPopulationFactory(new IntegerPopulationFactory())
		.withFitnessCalculationAlgorithm(fitnessCalculationAlgorithm).withMutationAlgorithm(mutationAlgorithm)
		.withRandomAlgorithm(randomAlgorithm).withReproductionAlgorithm(reproductionAlgorithm)
		.withSelectionAlgorithm(selectionAlgorithm);
	Engine<Integer> nonogramSolver = new SolutionSolver(engineBuilder);
	nonogramSolver.exec();
	Individual<Integer> individual = nonogramSolver.getBestIndividual();
	System.out.println(individual.toString());
	Assert.assertNotNull(individual);
    }
}
