package fr.epita.assistants.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new MyRecursiveTask(
                this.matrix, xLowerBound, xUpperBound / 2, 
                yLowerBound, yUpperBound / 2));
        dividedTasks.add(new MyRecursiveTask(
                this.matrix, xUpperBound / 2, xUpperBound,
                yLowerBound, yUpperBound / 2));
        dividedTasks.add(new MyRecursiveTask(
                this.matrix, xLowerBound, xUpperBound / 2,
                yUpperBound / 2, yUpperBound));
        dividedTasks.add(new MyRecursiveTask(
                this.matrix, xUpperBound / 2, xUpperBound,
                yUpperBound / 2, yUpperBound));
        return dividedTasks;
    }

    @Override
    protected Double compute() {
        if (  xUpperBound - xLowerBound <= THRESHOLD && yUpperBound - yLowerBound  <= THRESHOLD)
        {
            Double avg = (double) 0;
            int nb = 0;
            for (int i = xLowerBound; i < xUpperBound; i++) {
                for (int j = yLowerBound; j < yUpperBound; j++) {
                    nb++;
                    avg += matrix[i][j];
                }
            }
            return nb == 0? 0 : avg / nb;
        }
        else
        {
            List<MyRecursiveTask> dividedTasks = createSubtasks();
            Double avg = (double) 0;
            for (int i = 0; i < dividedTasks.size(); i++)
            {
                avg += dividedTasks.get(i).compute();
            }
            return dividedTasks.size() == 0? 0 :avg / dividedTasks.size();
        }
    }
}
