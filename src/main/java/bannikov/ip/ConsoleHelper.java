package bannikov.ip;

import java.util.Scanner;

public class ConsoleHelper {

    public static String getStrFromKb(String str) {
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
        String ipFromKB = sc.nextLine();
        return ipFromKB;
    }
}
