package pl.chodan;

import pl.chodan.algorithms.Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Calculations {


    private List<Data> dataList;
    private Map<String, List<Double>> weightsForIrisType = new HashMap<>();
    private Map<String, Integer> thetaForIrisType = new HashMap<>();
    List<Double> weights = new ArrayList<>();


    public Calculations(List<Data> data) {
        dataList = data;
        generateWeights();
        invokeAlgorith();


//        dataList.stream().forEach(data1 -> calculateNet(data1));
    }

    private void generateWeights() {
        Random r = new Random();
        dataList.get(0).getInputs().forEach(data -> weights.add(-1 + 2 * r.nextDouble()));
    }

    public void invokeAlgorith() {
        Set<String> typeSet = dataList.stream().map(data -> data.getIrisType()).collect(Collectors.toSet());
        for (String irisType : typeSet) {
            executeTraining(irisType);
        }


    }

    private void executeTraining(String irisType) {
        Algorithm algorithm = new Algorithm(weights, irisType);
        List<Double> setosaOutputWeights = null;
        for (int i = 0; i < dataList.size(); i++) {
            train(algorithm, i);
            for (int j = 0; j <= i; j++) {
                train(algorithm, j);
            }
            if (i == dataList.size() - 1) {
                setosaOutputWeights = algorithm.getWeights();
                thetaForIrisType.put(irisType,algorithm.gettheta());
            }
        }
        weightsForIrisType.put(irisType, setosaOutputWeights);


    }

    private void train(Algorithm algorithm, int j) {
        algorithm.setData(dataList.get(j));
        algorithm.setD(algorithm.generateDValue());
        algorithm.training();
    }

    public Map<String, List<Double>> getWeightsForIrisType() {
        return weightsForIrisType;
    }

    public Map<String, Integer> getThetaForIrisType() {
        return thetaForIrisType;
    }
}
