package com.eugeniuparvan.nonograms.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.nonograms.defenition.INonogramFactory;

@Component
public class NonogramFactory implements INonogramFactory
{
    @Override
    public INonogram getNonogram(File file)
    {
	List<List<Integer>> topNumberCollection = new ArrayList<List<Integer>>();
	List<List<Integer>> leftNumberCollection = new ArrayList<List<Integer>>();

	BufferedReader in;
	try
	{
	    in = new BufferedReader(new FileReader(file));
	    String line = "";
	    boolean isTop = true;
	    while ((line = in.readLine()) != null)
	    {
		if (line.equals("#"))
		{
		    isTop = false;
		    continue;
		}
		List<String> strings = Arrays.asList(line.split(","));
		List<Integer> ints = strings.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		if (isTop)
		    topNumberCollection.add(ints);
		else
		    leftNumberCollection.add(ints);
	    }
	}
	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}

	return new Nonogram(topNumberCollection, leftNumberCollection);
    }

}
