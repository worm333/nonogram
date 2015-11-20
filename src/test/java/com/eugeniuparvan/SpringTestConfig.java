package com.eugeniuparvan;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.eugeniuparvan.nonograms.defenition.INonogram;
import com.eugeniuparvan.nonograms.implementation.NonogramFactory;

@Configuration
@ComponentScan(basePackages =
{
	"com.eugeniuparvan.nonograms", "com.eugeniuparvan.solver"
})
public class SpringTestConfig
{

    @Bean
    public INonogram getNonogram()
    {
	return new NonogramFactory().getNonogram(new File(this.getClass().getResource("/test").getFile()));
    }
}
