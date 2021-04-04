import java.util.List;

public class Perceptron {

    List<Double> inputs;
    List<Double> weights;
    int y;
    int d;


    public Perceptron(List<Double> inputs, List<Double> weights, int y, int d) {
        this.inputs = inputs;
        this.weights = weights;
        this.y = y;
        this.d = d;
    }

    public List<Double> getInputs() {
        return inputs;
    }

    public void setInputs(List<Double> inputs) {
        this.inputs = inputs;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Perceptron{" +
                "inputs=" + inputs +
                ", weights=" + weights +
                ", y=" + y +
                ", d=" + d +
                '}';
    }
}
