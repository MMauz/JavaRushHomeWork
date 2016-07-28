package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        Cat cat1 = new Cat("cat11");
        Cat cat2 = new Cat("cat12");
        Cat cat3 = new Cat("cat13");
        Cat cat4 = new Cat("cat14");
        Cat cat5 = new Cat("cat15");
        Cat cat6 = new Cat("cat16");
        Cat cat7 = new Cat("cat17");
        Cat cat8 = new Cat("cat18");
        Cat cat9 = new Cat("cat19");
        Cat cat10 = new Cat("cat10");
        map.put("cat21", cat1);
        map.put("cat22", cat2);
        map.put("cat23", cat3);
        map.put("cat24", cat4);
        map.put("cat25", cat5);
        map.put("cat26", cat6);
        map.put("cat27", cat7);
        map.put("cat28", cat8);
        map.put("cat29", cat9);
        map.put("cat20", cat10);

        return map;


    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair: map.entrySet())
            set.add(pair.getValue());

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
