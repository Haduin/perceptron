package pl.chodan;

import java.util.List;

public class Perceptron {

    final String perceptronType;
    final List<Double> weights;
    final int theta;


    public Perceptron(List<Double> weights, int theta, String perceptronType) {
        this.weights = weights;
        this.theta = theta;
        this.perceptronType = perceptronType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\nPerceptron dla typu: %s",perceptronType));
        stringBuilder.append("\nWagi:");
        for (Double weight:weights) {
         stringBuilder.append(String.format("\n%s", weight));
        }
        stringBuilder.append(String.format("\nPróg: %d",theta));

        return stringBuilder.toString();
    }
}
