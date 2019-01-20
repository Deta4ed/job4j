package ru.job4j.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class BiteStream {
    public boolean isNumber(InputStream in) {
        int num;
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            num = Integer.valueOf(br.readLine());
            if (num % 2 == 0) {
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
