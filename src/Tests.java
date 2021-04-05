import java.util.List;
import java.util.Map;

public class Tests {

    final List<Data> testData;
    final Map<String, List<Double>> weightsForIrisType;
    final int theta;

    public Tests(List<Data> testData, Map<String, List<Double>> weightsForIrisType, int theta) {
        this.testData = testData;
        this.weightsForIrisType = weightsForIrisType;
        this.theta = theta;
    }

    public void performTest() {
        SetosaAlgorithm setosaAlgorithm = new SetosaAlgorithm(weightsForIrisType.get("setosa"));
        setosaAlgorithm.setTheta(theta);


        for (int i = 0; i < testData.size(); i++) {
            setosaAlgorithm.setData(testData.get(i));
            setosaAlgorithm.setD(1);
            boolean yEqualsD = setosaAlgorithm.isYEqualsD(testData.get(i));
            System.out.println(testData.get(i).getIrisType() + ": " + yEqualsD);
        }
        System.out.println(setosaAlgorithm.getWeights());


    }


}
