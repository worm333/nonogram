package com.eugeniuparvan.solver;

import com.eugeniuparvan.genetic.defenition.Fitness;

public class SolutionFitness implements Fitness
{
    private float errors;

    @Override
    public boolean isBetter(Fitness fitness)
    {
	return getValue() < fitness.getValue();
    }

    @Override
    public boolean isBest()
    {
	return getValue() == 0;
    }

    @Override
    public float getValue()
    {
	return errors;
    }

    @Override
    public void setValue(float value)
    {
	this.errors = value;
    }
}
