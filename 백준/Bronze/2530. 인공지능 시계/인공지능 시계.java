import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int sec = scanner.nextInt();
        int time = scanner.nextInt();

        int total_sec = hour * 3600 + min * 60 + sec + time;

        int cur_hour = (total_sec / 60 / 60) % 24;
        int cur_min = total_sec / 60 % 60;
        int cur_sec = total_sec % 60;

        System.out.println(cur_hour + " " + cur_min + " " + cur_sec);
    }
}
