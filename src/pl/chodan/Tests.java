package pl.chodan;

import pl.chodan.algorithms.Algorithm;


import java.util.List;
import java.util.Map;

public class Tests {

    final List<Data> testData;
    final Map<String, List<Double>> weightsForIrisType;
    final private Map<String, Integer> thetaForIrisType;

    public Tests(List<Data> testData, Map<String, List<Double>> weightsForIrisType, Map<String, Integer> thetaForIrisType) {
        this.testData = testData;
        this.weightsForIrisType = weightsForIrisType;
        this.thetaForIrisType= thetaForIrisType;
        
        invokeTests();
    }

    private void invokeTests() {
        
        weightsForIrisType.forEach((irisType,v) -> performTestForIrisType(irisType,thetaForIrisType.get(irisType)));
       
        
        
    }

    private void performTestForIrisType(String irisType, Integer theta) {
        System.out.println();
        System.out.printf("TEST FOR %s",irisType);
        System.out.println();
        Algorithm algorithm = new Algorithm(weightsForIrisType.get(irisType),irisType);
        algorithm.setTheta(theta);


        for (int i = 0; i < testData.size(); i++) {
            algorithm.setData(testData.get(i));
            algorithm.setD(1);
            boolean yEqualsD = algorithm.isYEqualsD(testData.get(i));
            System.out.println(testData.get(i).getIrisType() + ": " + yEqualsD);
        }
        System.out.println(algorithm.getWeights());//TODO wypisać procent
    }

//    public void performTest() {
//
//
//       
//
//
//    }


}
