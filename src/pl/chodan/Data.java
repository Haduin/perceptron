package pl.chodan;

import java.util.List;

public class Data {

    private List<Double> inputs;
    private String irisType;

    public Data(List<Double> inputs, String irisType) {
        this.inputs = inputs;
        this.irisType = irisType;
    }

    public List<Double> getInputs() {
        return inputs;
    }

    public void setInputs(List<Double> inputs) {
        this.inputs = inputs;
    }

    public String getIrisType() {
        return irisType;
    }

    public void setIrisType(String irisType) {
        this.irisType = irisType;
    }

    @Override
    public String toString() {
        return "pl.chodan.Data{" +
                "inputs=" + inputs +
                ", irisType='" + irisType + '\'' +
                '}';
    }
}
