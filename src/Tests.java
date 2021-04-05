import java.util.List;
import java.util.Map;

public class Tests {

    final List<Data> testData;
    final Map<String, List<Double>> weightsForIrisType;
    public Tests(List<Data> testData, Map<String, List<Double>> weightsForIrisType) {
        this.testData = testData;
        this.weightsForIrisType = weightsForIrisType;
    }

    public void performTest(){
        SetosaAlgorithm setosaAlgorithm = new SetosaAlgorithm(weightsForIrisType.get("setosa"));


        for (int i=0;i<testData.size();i++){
            boolean yEqualsD = setosaAlgorithm.isYEqualsD(testData.get(i));

            System.out.println(testData.get(i).getIrisType()+": "+yEqualsD);

        }
        System.out.println(setosaAlgorithm.getWeights());


    }



}
