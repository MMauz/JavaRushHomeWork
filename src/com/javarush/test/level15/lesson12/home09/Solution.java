package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //String url = "javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0";

        int position = url.indexOf("?");
        String cutUrl = url.substring(position + 1);

        Pattern pattern = Pattern.compile("&+");
        String[] tokens = pattern.split(cutUrl);

        ArrayList<String> objList = new ArrayList<String>();

        Pattern objPattern = Pattern.compile("^obj=.");
        for (String element: tokens)
        {
            if (objPattern.matcher(element).find()) {objList.add(element.substring(element.indexOf("=") + 1));}
            if (element.contains("=")) {System.out.print(element.substring(0, element.indexOf("=")) + " ");}
            else System.out.print(element + " ");
        }
        System.out.println();

        Pattern doublePattern = Pattern.compile("^[0-9.]");

        for (String element: objList)
        {
            if (doublePattern.matcher(element).find()) {alert(Double.parseDouble(element));}
            else {alert(element);}
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
