package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода!");
            return "";
        }
    }

    public static void writeString(String s){
        System.out.println(s);
    }


}
