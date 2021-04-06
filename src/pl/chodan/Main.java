package pl.chodan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Data> trainingData = new ArrayList<>();
        List<Data> testData = new ArrayList<>();

        try {
            trainingData = loadFromFile("iris_training.txt");
            testData = loadFromFile("iris_test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Calculations calculations = new Calculations(trainingData);
        Map<String, List<Double>> weightsForIrisType = calculations.getWeightsForIrisType();
        Map<String, Integer> thetaForIrisType = calculations.getThetaForIrisType();
        Tests tests = new Tests(testData,weightsForIrisType,thetaForIrisType);
//        tests.performTest();
        System.out.println(weightsForIrisType);
//        System.out.println(pl.chodan.algorithms.SetosaAlgorithm.theta);

        Scanner scanner = new Scanner(System.in);

        List<Double> doubles;
        Integer theta;
        String[] lines;
        String line = scanner.nextLine();
        int k =0;
        while(!line.equals("end")){

            System.out.println("podaj dane :");
            lines = scanner.nextLine().replace(",",".").split(" ");


             doubles= weightsForIrisType.get("Iris-virginica");
                theta    = thetaForIrisType.get("Iris-virginica");

            double net = 0;

            for(int i = 0;i< lines.length-1;i++){
                net+=Double.parseDouble(lines[i])*doubles.get(i);
            }
            if(net-theta>=0){
                System.out.println("Iris-virginica");
                k++;
            }


            doubles = weightsForIrisType.get("Iris-setosa");
            theta = thetaForIrisType.get("Iris-setosa");
             net = 0;

            for(int i = 0;i< lines.length-1;i++){
                net+=Double.parseDouble(lines[i])*doubles.get(i);
            }
            if(net-theta>=0){
                System.out.println("Iris-setosa");
                k++;
            }



            doubles = weightsForIrisType.get("Iris-versicolor");
            theta = thetaForIrisType.get("Iris-versicolor");
             net = 0;

            for(int i = 0;i< lines.length-1;i++){
                net+=Double.parseDouble(lines[i])*doubles.get(i);
            }
            if(net-theta>=0){
                System.out.println("Iris-versicolor");
                k++;
            }

            if(k==0)
                System.out.println("brak dopasowania");
            System.out.println("Zakończyć ? Wpisz 'end'");
            line = scanner.nextLine();


//            System.out.println(weightsForIrisType);
//            System.out.println(thetaForIrisType);



        }


    }


    public static List<Data> loadFromFile(String source) throws FileNotFoundException {
        List<Data> listOfData= new ArrayList<>();
        Scanner scanner = new Scanner(new File(source));
        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().split(" ");
            List<Double> listOfInputs = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",")){
                    String replacedInput = split[i].replace(",", ".");
                    listOfInputs.add(Double.parseDouble(replacedInput));
                    continue;
                }
                else {
                    listOfData.add(new Data(listOfInputs,split[i]));
                }
            }

        }
        scanner.close();
        return listOfData;
    }

}
