package com.eugeniuparvan.nonograms.implementation;

import org.junit.Assert;
import org.junit.Test;

import com.eugeniuparvan.NonogramTest;

public class NonogramFactoryTest extends NonogramTest
{
    @Test
    public void getNonogram()
    {
	Assert.assertFalse(nonogram.getLeftNumberCollection().isEmpty());
	Assert.assertFalse(nonogram.getTopNumberCollection().isEmpty());
    }
}
