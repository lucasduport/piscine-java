package fr.epita.assistants.forkjoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {
    private static final int THRESHOLD = 5;
    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    protected Double compute() {
        if (  xUpperBound - xLowerBound <= THRESHOLD && yUpperBound - yLowerBound  <= THRESHOLD)
        {
            Double avg = (double) 0;
            int nb = 0;
            for (int i = yLowerBound; i < yUpperBound; i++) {
                for (int j = xLowerBound; j < xUpperBound; j++) {
                    nb++;
                    avg += matrix[i][j];
                }
            }
            return nb == 0? 0 : avg / nb;
        }
        else
        {
            Double avg = (double) 0;
            avg += new MyRecursiveTask(
                    this.matrix, xLowerBound, xUpperBound / 2,
                    yLowerBound, yUpperBound / 2).compute();
            avg +=  new MyRecursiveTask(
                    this.matrix, xUpperBound / 2, xUpperBound,
                    yLowerBound, yUpperBound / 2).compute();
            avg += new MyRecursiveTask(
                    this.matrix, xLowerBound, xUpperBound / 2,
                    yUpperBound / 2, yUpperBound).compute();
            avg += new MyRecursiveTask(
                    this.matrix, xUpperBound / 2, xUpperBound,
                    yUpperBound / 2, yUpperBound).compute();
            return avg / 4;
        }
    }
}
