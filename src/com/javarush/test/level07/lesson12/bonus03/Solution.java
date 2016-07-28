package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> hash = new HashSet<String>();
        hash.add("арбуз");
        hash.add("банан");
        hash.add("вишня");
        hash.add("груша");
        hash.add("дыня");
        hash.add("ежевика");
        hash.add("жень-шень");
        hash.add("земляника");
        hash.add("ирис");
        hash.add("картофель");

        for (String element : hash)
            System.out.println(element);
    }
}
