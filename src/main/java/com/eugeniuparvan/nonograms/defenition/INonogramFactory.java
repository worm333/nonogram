package com.eugeniuparvan.nonograms.defenition;

import java.io.File;

public interface INonogramFactory
{
    public INonogram getNonogram(File file);
}
