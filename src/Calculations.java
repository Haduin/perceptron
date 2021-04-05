import java.util.*;

public class Calculations {


    private List<Data> dataList;
    private Map<String,List<Double>> weightsForIrisType = new HashMap<>();
    private int theta;
    List<Double> weights = new ArrayList<>();


    public Calculations(List<Data> data) {
        dataList = data;
        generateWeights();
        invokeAlgorith();

//        dataList.stream().forEach(data1 -> calculateNet(data1));
    }

    private void generateWeights() {
        Random r = new Random();

        dataList.get(0).getInputs().forEach(data ->weights.add(-1 + 2 * r.nextDouble()));
    }

    public void invokeAlgorith(){
        SetosaAlgorithm setosaAlgorithm = new SetosaAlgorithm(weights);
        List<Double> setosaOutputWeights = null;
        for(int i=0; i<dataList.size();i++){
            setosaAlgorithm.setData(dataList.get(i));
            setosaAlgorithm.setD(setosaAlgorithm.generateDValue());
            setosaAlgorithm.training();

            /**
             * 1. recalculateWeight -> (dla d=1) -> y!=d
             *
             *
             */

//            for(int j=0; j<=4;j++){
            for(int j=0; j<=i;j++){
                setosaAlgorithm.setData(dataList.get(j));
                setosaAlgorithm.setD(setosaAlgorithm.generateDValue());
                setosaAlgorithm.training();
            }
            if (i==dataList.size()-1){
                setosaOutputWeights = setosaAlgorithm.getWeights();
                this.theta = setosaAlgorithm.gettheta();
            }
        }
         weightsForIrisType.put("setosa",setosaOutputWeights);




    }

    public Map<String, List<Double>> getWeightsForIrisType() {
        return weightsForIrisType;
    }

    public int getTheta() {
        return theta;
    }
}
