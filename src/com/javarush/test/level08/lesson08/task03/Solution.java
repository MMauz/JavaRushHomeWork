package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Иванов13"));
        System.out.println(getCountTheSameLastName(map, "Иван1"));

    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Иванов1", "Иван");
        map.put("Иванов2", "Иван1");
        map.put("Иванов3", "Иван3");
        map.put("Иванов4", "Иван1");
        map.put("Иванов5", "Иван4");
        map.put("Иванов6", "Иван");
        map.put("Иванов7", "Иван2");
        map.put("Иванов8", "Иван");
        map.put("Иванов9", "Иван");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        return (map.containsKey(name)) ? 1 : 0;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;
        for (String element : map.values()){
            if (lastName.equals(element))
                count++;
        }

        return count;

    }
}
