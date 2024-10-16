import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String val;
        // set placeholder for 2 values
        String[] values = {};
        List<String> operator = new ArrayList<String>(10);
        Scanner inp = new Scanner(System.in);
        val = inp.nextLine();
        //split each character
        for (int i=0; i<val.length(); i++){
            //Single out operator
            if (val.substring(i, i+1).equals("*") || val.substring(i, i+1).equals("?") || val.substring(i, i+1).equals("-") || val.substring(i, i+1).equals("+")){
                operator.add(val.substring(i, i+1));
            }
        }
        //split all numbers
        if (val.indexOf("*") != -1 || val.indexOf("/") != -1 || val.indexOf("-") != -1 || val.indexOf("+") != -1) {
            values = val.split("[*/+-]");
        }
        double calculate = Double.parseDouble(values[0]);
        for (int v=0; v<operator.size(); v++){
                if (operator.get(v).equals("*")) {
                    calculate *= Double.parseDouble(values[v+1]);
                } else if (operator.get(v).equals("/")) {
                    calculate /= Double.parseDouble(values[v+1]);
                } else if (operator.get(v).equals("-")) {
                    calculate -= Double.parseDouble(values[v+1]);
                } else if (operator.get(v).equals("+")) {
                    calculate += Double.parseDouble(values[v+1]);
                }
        }
        System.out.print(calculate);
    }
}
