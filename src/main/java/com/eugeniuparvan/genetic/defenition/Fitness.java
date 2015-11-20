package com.eugeniuparvan.genetic.defenition;

public interface Fitness
{
    public float getValue();

    public void setValue(float value);

    public boolean isBetter(Fitness fitness);

    public boolean isBest();
}
