import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SetosaAlgorithm {


    private Data data;
    private int theta=5;
    private static String IRIS_TYPE="setosa";
    private List<Double> operationalWeights;
    private int y;
    public SetosaAlgorithm(List<Double> weights) {
        operationalWeights = new ArrayList<>(weights);
    }



/*

    public SetosaAlgorithm(Data data, List<Double> weights) {
        this.data = data;
        this.weights = weights;
        this.d = generateDValue();
        training();
    }
*/
    public int generateDValue() {
        return data.getIrisType().toLowerCase().contains(IRIS_TYPE)?1:0;
    }

    public void training() {
         while (!isYEqualsD(data)){
             relaculateWeights();
         }
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
}
