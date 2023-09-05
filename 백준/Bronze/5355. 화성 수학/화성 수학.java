import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < T; i++){
            List<String> mathExpression = input(scanner, T);
            double answer = calculate(mathExpression);
            System.out.printf("%.2f\n", answer);
        }
    }

    public static List<String> input(Scanner scanner, int T) {
        List<String> mathExpression = new ArrayList<>();
        String str;
        String[] strToArr;

        str = scanner.nextLine();
        strToArr = str.split(" ");
        Arrays.stream(strToArr).forEach(item -> mathExpression.add(item));

        return mathExpression;
    }

    public static double calculate(List<String> mathExpression){
        double value = Double.parseDouble(mathExpression.get(0));

        for (String str : mathExpression){
            if (str.equals("@")){
                value *= 3;
            }else if (str.equals("%")){
                value += 5;
            }else if (str.equals("#")){
                value -= 7;
            }
        }
        return value;
    }
}
