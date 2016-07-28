package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();

        char[] arrayAll = in.toCharArray();
        ArrayList<Character> arrayOfAll = new ArrayList<Character>();

        for (int i = 0; i < arrayAll.length; i++)
            if (arrayAll[i] != ' ')
                arrayOfAll.add(arrayAll[i]);


        ArrayList<Character> arrayOfVowel = new ArrayList<Character>();
        ArrayList<Character> arrayOfConsonant = new ArrayList<Character>();
        for (int i = 0; i < arrayOfAll.size(); i++){
            if (isVowel(arrayOfAll.get(i)))
            {
                arrayOfVowel.add(arrayOfAll.get(i));
                arrayOfVowel.add(' ');
            }
            else
            {
                arrayOfConsonant.add(arrayOfAll.get(i));
                arrayOfConsonant.add(' ');
            }
        }

        for (Character element: arrayOfVowel)
            System.out.print(element);

        System.out.println();

        for (Character element: arrayOfConsonant)
            System.out.print(element);
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
