package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        StringBuffer tmp = new StringBuffer();
        //String result = "";
        for (int i = 0; i < 1000000; i++){
            //result += i;
            tmp.append(i);
        }
        //System.out.println(result);
        System.out.println(tmp);
    }
}
