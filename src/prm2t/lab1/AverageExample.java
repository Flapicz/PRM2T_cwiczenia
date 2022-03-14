package prm2t.lab1;

import java.util.ArrayList;
import java.util.List;

public class AverageExample {

    private List<Double> values = new ArrayList<>();

    public AverageExample(String[] args) {
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            values.add(Double.parseDouble(args[i]));
        }
        /* try alternatively:
        for (String arg : args) {
            values.add(Integer.parseInt(arg));
        }*/
    }

    public double calculateAverage() {
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public static void main(String[] args) {
        AverageExample averageExample = new AverageExample(args);
        System.out.println(averageExample.calculateAverage());
    }
}
