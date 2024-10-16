import java.util.Scanner;
public class Problem {
    public static void main(String[] args) {
        int len;
        char ulCase;
        Scanner stdin = new Scanner(System.in);
        System.out.println("enter the length of string:");
        len = stdin.nextInt();
        System.out.println("enter the case input:");
        ulCase = stdin.next().toLowerCase().charAt(0);
        if (len < 0 || (ulCase != 'u') && (ulCase != 'l')){
            System.out.println("improper case input try again !");
        } else
        if(ulCase == 'u') {
            for(int i = 0; i < len; i++) {
                System.out.print((char)('A' + (int)('Z' - 'A' +  1)*Math.random()));
            }
        }else if(ulCase == 'l') {
            for(int i = 0; i < len; i++) {
                System.out.print((char)('a' + (int)('z' - 'a' +  1)*Math.random()));
            }
        }
    }
}

//import java.util.Scanner;
//public class Problem {
//public static void main(String[] args) {
//int len;
//char ulCase;
//Scanner stdin = new Scanner(System.in);
//System.out.println("enter the length of string:");
//len = stdin.nextInt();
//if (len > 0){
//System.out.println("enter the case input:");
//ulCase = stdin.next().charAt(0);
//String randString = "";
//char inputChar;
//if(ulCase == 'u' || ulCase == 'U') {
//for(int i = 0; i < len; i++) {
//inputChar = (char)('A' + (int)('Z' - 'A' +
//1)*Math.random());
//randString += inputChar;
//}
//}else if(ulCase == 'l' || ulCase == 'L') {
//for(int i = 0; i < len; i++) {
//inputChar = (char)('a' + (int)('z' - 'a' +
//1)*Math.random());
//randString += inputChar;
//}
//}
//if((ulCase != 'u') && (ulCase != 'U') && (ulCase != 'l') && (ulCase !=
//'L'))
//System.out.println("improper case input try again !");
//else
//System.out.println("random string: " + randString);
//}
//else
//System.out.println("please enter a positive greater than 0 len");
//stdin.close();
//}
//}