package supportFiles;

import java.util.Scanner;

public class ConsoleReader {
    private static Scanner input = new Scanner(System.in);

    public static String getStringData(String message) {
        System.out.print("\n" + message + "->");
        return input.next();
    }

    public static int getIntData(String message){
        System.out.print("\n" + message + "->");
        return input.nextInt();
    }
}
