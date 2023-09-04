import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R1 = scanner.nextInt();
        int S = scanner.nextInt();
        int R2 = S*2 - R1;

        System.out.println(R2);
    }
}
