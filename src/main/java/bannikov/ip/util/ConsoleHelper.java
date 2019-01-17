package bannikov.ip.util;

import java.util.Scanner;

public class ConsoleHelper {

    public static String getStrFromKb(String str) {
        System.out.println(str);
        return new Scanner(System.in).nextLine();
    }
}
