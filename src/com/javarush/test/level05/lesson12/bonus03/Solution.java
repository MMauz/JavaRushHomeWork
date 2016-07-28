package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;

        //напишите тут ваш код
        int count = Integer.parseInt(reader.readLine());
        for (int n = 0; n < count; n++){
            int number = Integer.parseInt(reader.readLine());
            maximum = maximum > number ? maximum : number;
        }
        System.out.println(maximum);
    }
}
