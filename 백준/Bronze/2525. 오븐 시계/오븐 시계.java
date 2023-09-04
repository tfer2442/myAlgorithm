import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int time = scanner.nextInt();
        int cur_hour;
        int cur_min;

        cur_min = time + min;
        cur_hour = (hour + cur_min / 60)%24;
        cur_min = cur_min % 60;
        System.out.println(cur_hour + " " + cur_min);
    }
}
