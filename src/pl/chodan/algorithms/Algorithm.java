package pl.chodan.algorithms;

import pl.chodan.Data;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    private Data data;
    private int theta=50;
    private String irisType;
    private List<Double> operationalWeights;
    private int y;
    public Algorithm(List<Double> weights, String irisType) {
        this.irisType=irisType;
        operationalWeights = new ArrayList<>(weights);
    }

    public int generateDValue() {
        return data.getIrisType().contains(irisType)?1:0;
    }

    public void training() {
        while (!isYEqualsD(data)){
            relaculateWeights();
        }
    }

    public List<Double> getOperationalWeights() {
        return operationalWeights;
    }

    public void relaculateWeights(){
        for (int i=0; i<operationalWeights.size();i++){
            Double weight = operationalWeights.get(i);
            weight=weight+(d-y)*data.getInputs().get(i);
            operationalWeights.set(i,weight);
        }
        theta=theta+(d-y);
    }

    public boolean isYEqualsD(Data data){
        y=calculateNet(data)>=theta?1:0;
        return y==d;
    }

    private int d;


    public double calculateNet(Data data){
        double net=0;

        for(int i = 0; i< data.getInputs().size(); i++){
            net+= data.getInputs().get(i)*operationalWeights.get(i);
        }
        return net;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setWeights(List<Double> weights) {
        this.operationalWeights = weights;
    }

    public List<Double> getWeights() {
        return operationalWeights;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int gettheta() {
        return theta;
    }

    public void setTheta(int theta) {
        this.theta = theta;
    }
}
