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
            return nb == 0 ? 0 : avg / nb;
        }
        else
        {

            var t1 = new MyRecursiveTask(
                    this.matrix, xLowerBound, (xUpperBound - xLowerBound) / 2 + xLowerBound,
                    yLowerBound, (yUpperBound - yLowerBound)/ 2 + yLowerBound).fork();
            var t2 =  new MyRecursiveTask(
                    this.matrix, (xUpperBound - xLowerBound) / 2 + xLowerBound, xUpperBound,
                    yLowerBound, (yUpperBound - yLowerBound) / 2 + yLowerBound).fork();
            var t3 = new MyRecursiveTask(
                    this.matrix, xLowerBound, (xUpperBound - xLowerBound) / 2 + xLowerBound,
                    (yUpperBound - yLowerBound) / 2 + yLowerBound, yUpperBound).fork();
            var t4 = new MyRecursiveTask(
                    this.matrix, (xUpperBound - xLowerBound) / 2 + xLowerBound, xUpperBound,
                    (yUpperBound - yLowerBound) / 2 + yLowerBound, yUpperBound).fork();

            return (t1.join() + t2.join() + t3.join() + t4.join()) / 4d;
        }
    }
}
