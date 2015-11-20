package com.eugeniuparvan.solver.algorithm.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomUtils implements IRandomUtils
{
    @Override
    public int getRandomNumberInRange(int min, int max)
    {
	if (min > max)
	    throw new IllegalArgumentException("max must be greater than min");
	else if (min == max)
	    return min;
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }

}
