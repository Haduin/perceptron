package pl.chodan;

import pl.chodan.algorithms.Algorithm;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tests {

    final List<Data> testData;
    final Map<String, List<Double>> weightsForIrisType;
    final private Map<String, Integer> thetaForIrisType;
    int sumOfAllMatches = 0;

    public Tests(List<Data> testData, Map<String, List<Double>> weightsForIrisType, Map<String, Integer> thetaForIrisType) {
        this.testData = testData;
        this.weightsForIrisType = weightsForIrisType;
        this.thetaForIrisType = thetaForIrisType;
        printInfosAboutPerceptrons();
        invokeTests();
    }

    private void printInfosAboutPerceptrons() {
        weightsForIrisType.entrySet().stream()
                .map(entry -> new Perceptron(entry.getValue(), thetaForIrisType.get(entry.getKey()), entry.getKey()))
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }



    private void invokeTests() {

        weightsForIrisType.forEach((irisType, v) -> performTestForIrisType(irisType, thetaForIrisType.get(irisType)));
        System.out.println();
        System.out.println("OGÓLNA DOKŁADNOŚĆ EKSPERYMENTU");
        System.out.println(String.format("%d / %d (Procentowo: %s",sumOfAllMatches,testData.size()*weightsForIrisType.size(), String.format("%.2f",(sumOfAllMatches* 100.0) /(testData.size()*weightsForIrisType.size())))+"%)");
    }

    private void performTestForIrisType(String irisType, Integer theta) {
        System.out.println();
        System.out.printf("TESTUJĘ: %s", irisType);
        System.out.println();
        Algorithm algorithm = new Algorithm(weightsForIrisType.get(irisType), irisType);
        algorithm.setTheta(theta);

        List<Classification> clasifications = new ArrayList<>();

        for (int i = 0; i < testData.size(); i++) {
            algorithm.setData(testData.get(i));
            algorithm.setD(1);
            boolean yEqualsD = algorithm.isYEqualsD(testData.get(i));
            clasifications.add(new Classification(testData.get(i).getIrisType(),yEqualsD));
        }


        System.out.println("Liczba prawidłowo zaklasyfikowanych przykładów testowych:");
        int quantityOfMatchedValues = calculateProperClassification(clasifications, testData, irisType);
        System.out.println(String.format("%d / %d (Procentowo: %s",quantityOfMatchedValues,clasifications.size(), String.format("%.2f",quantityOfMatchedValues* 100.0 /clasifications.size()))+"%)");
        sumOfAllMatches+=quantityOfMatchedValues;
    }

    private int calculateProperClassification(List<Classification> classifications, List<Data> testData, String irisType) {
        int counter = 0;

        for (int i=0;i< classifications.size();i++){

            if (testData.get(i).getIrisType().equals(irisType)){
                if (classifications.get(i).isMatch()){
                    counter++;
                }
            }
            else {
                if (!classifications.get(i).isMatch()){
                    counter++;
                }
            }
        }

       return counter;
    }
}
