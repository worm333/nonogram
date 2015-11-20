package com.eugeniuparvan.genetic.defenition.behaviour;

import java.util.List;
import java.util.Map;

import com.eugeniuparvan.genetic.defenition.Individual;
import com.eugeniuparvan.genetic.defenition.Population;

public interface SelectionAlgorithm<C>
{
    public Map<Integer, List<Individual<C>>> select(Population<C> population);
}
