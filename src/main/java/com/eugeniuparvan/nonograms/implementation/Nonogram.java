package com.eugeniuparvan.nonograms.implementation;

import java.util.List;

import com.eugeniuparvan.nonograms.defenition.INonogram;

public class Nonogram implements INonogram
{
    private int width;
    private int height;

    private List<List<Integer>> topNumberCollection;
    private List<List<Integer>> leftNumberCollection;

    public Nonogram(List<List<Integer>> topNumberCollection, List<List<Integer>> leftNumberCollection)
    {
	this.topNumberCollection = topNumberCollection;
	this.leftNumberCollection = leftNumberCollection;
	this.width = topNumberCollection.size();
	this.height = leftNumberCollection.size();
    }

    public List<List<Integer>> getTopNumberCollection()
    {
	return topNumberCollection;
    }

    public List<List<Integer>> getLeftNumberCollection()
    {
	return leftNumberCollection;
    }

    public int getWidth()
    {
	return width;
    }

    public int getHeight()
    {
	return height;
    }
}
