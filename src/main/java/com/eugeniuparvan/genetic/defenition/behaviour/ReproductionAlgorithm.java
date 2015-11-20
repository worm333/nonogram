package com.eugeniuparvan.genetic.defenition.behaviour;

import java.util.List;

import com.eugeniuparvan.genetic.defenition.Individual;

public interface ReproductionAlgorithm<C>
{
    public List<Individual<C>> reproduce(List<Individual<C>> parents);
}
