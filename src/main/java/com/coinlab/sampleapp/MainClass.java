/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinlab.sampleapp;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 *
 * @author seadahai
 */
public class MainClass {

    public static void main(String[] args) {
        plotNormalDistHist();
    }

    public static void plotNormalDistHist() throws NotStrictlyPositiveException {
        System.out.println("Hello Maven World!");
        NormalDistribution normal = new NormalDistribution(0, 1);
        double[] value = new double[1000];
        for (int i = 1; i < value.length; i++) {
            value[i] = normal.sample();
        }
        int number = 20;
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", value, number, -3, 3);
        String plotTitle = "Histogram";
        String xaxis = "number";
        String yaxis = "value";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis,
                dataset, orientation, show, toolTips, urls);
        int width = 300;
        int height = 300;
        try {
            ChartUtilities.saveChartAsPNG(new File("histogram.png"), chart, width, height);
        } catch (IOException e) {
        }
    }
}
