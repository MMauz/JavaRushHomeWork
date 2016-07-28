package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> allEvenNums = new ArrayList<Integer>();


        while (readerFile.ready()){
            Integer num = Integer.parseInt(readerFile.readLine());
            if (num % 2 == 0)
                allEvenNums.add(num);
        }

        Collections.sort(allEvenNums);

        for (Integer element : allEvenNums)
            System.out.println(element);

    }
}
