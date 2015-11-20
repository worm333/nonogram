package com.eugeniuparvan.nonograms.defenition;

import java.util.List;

public interface INonogram
{
    public List<List<Integer>> getTopNumberCollection();

    public List<List<Integer>> getLeftNumberCollection();

    public int getWidth();

    public int getHeight();
}
