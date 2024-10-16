import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner val = new Scanner(System.in);
        char ch = val.next().charAt(0);
        System.out.print(ch > '0');
    }
}
