package pl.chodan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        new Tests(testData,weightsForIrisType,thetaForIrisType);

        Scanner scanner = new Scanner(System.in);

        while(scanner.nextLine().equals("end")){
            System.out.println("podaj dane :");
            String[] line = scanner.nextLine().split(" ");
            

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
