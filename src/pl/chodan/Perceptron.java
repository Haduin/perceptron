package pl.chodan;

import java.util.List;

public class Perceptron {


    final List<Double> weights;
    final int theta;


    public Perceptron(List<Double> weights, int theta) {
        this.weights = weights;
        this.theta = theta;
    }

    @Override
    public String toString() {
        return "Perceptron{" +
                "weights=" + weights +
                ", theta=" + theta +
                '}';
    }
}
