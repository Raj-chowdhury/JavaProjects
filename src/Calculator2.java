import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        String val;
        // set placeholder for 2 values
        String[] place = {};
        ArrayList<String> values = new ArrayList<String>();
        List<String> operator = new ArrayList<String>(10);
        Scanner inp = new Scanner(System.in);
        val = inp.nextLine();
        //split each character
        for (int i=0; i<val.length(); i++){
            //Single out operator
            if (val.substring(i, i+1).equals("*") || val.substring(i, i+1).equals("/") || val.substring(i, i+1).equals("-") || val.substring(i, i+1).equals("+")){
                operator.add(val.substring(i, i+1));
            }
        }
        //split all numbers
        if (val.indexOf("*") != -1 || val.indexOf("/") != -1 || val.indexOf("-") != -1 || val.indexOf("+") != -1) {
            place = val.split("[*/+-]");
            for (int i = 0; i< place.length; i++) {
                values.add(place[i]);
            }
        }
        double result = 0;
        while (true) {
            while (operator.contains("*") || operator.contains("/")) {
                int location = 0;
                for (int i = 0; i<operator.size(); i++) {
                    if (operator.get(i).equals("*")) {
                        location = operator.indexOf("*");
                        result = Double.parseDouble(values.get(location))*Double.parseDouble(values.get(location+1));
                        break;
                    } else if (operator.get(i).equals("/")){
                        location = operator.indexOf("/");
                        result = Double.parseDouble(values.get(location))/Double.parseDouble(values.get(location+1));
                        break;
                    }
                }

                values.set(location, String.valueOf(result));
                operator.remove(operator.get(location));
                values.remove(location+1);
                if (values.size() == 1) {
                    result = Double.parseDouble(values.getFirst());
                }
            }
            while (operator.contains("+") || operator.contains("-")) {
                int location = 0;
                for (int i = 0; i<operator.size(); i++) {
                    if (operator.get(i).equals("+")) {
                        location = operator.indexOf("+");
                        break;
                    } else if (operator.get(i).equals("-")){
                        location = operator.indexOf("-");
                        break;
                    }
                }
                if (operator.get(location).equals("+")) {
                    result = Double.parseDouble(values.get(location))+Double.parseDouble(values.get(location+1));
                } else if (operator.get(location).equals("-")){
                    result = Double.parseDouble(values.get(location))-Double.parseDouble(values.get(location+1));
                }
                values.set(location, String.valueOf(result));
                operator.remove(operator.get(location));
                values.remove(location+1);
                if (values.size() == 1) {
                    result = Double.parseDouble(values.getFirst());
                }
            }
            System.out.print(result);
            break;
        }
    }
}
