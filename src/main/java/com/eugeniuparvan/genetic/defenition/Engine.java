package com.eugeniuparvan.genetic.defenition;

public interface Engine<C>
{
    public Individual<C> getBestIndividual();

    public void exec();
}
