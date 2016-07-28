package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human child1 = new Human("сын Петро", true, 1);
        System.out.println(child1);
        Human child2 = new Human("сын Федорка", true, 5);
        System.out.println(child2);
        Human child3 = new Human("дочь Ульяна", false, 13);
        System.out.println(child3);
        ArrayList<Human> ch1 = new ArrayList<Human>();
        ch1.add(child1);
        ch1.add(child2);
        ch1.add(child3);

        Human f = new Human("отец Егор", true, 35, ch1);
        System.out.println(f);
        Human m = new Human("мать Прасковья", false, 29, ch1);
        System.out.println(m);
        ArrayList<Human> ch2 = new ArrayList<Human>();
        ArrayList<Human> ch3 = new ArrayList<Human>();
        ch2.add(f);
        ch3.add(m);

        Human gf1 = new Human("дед Иван", true, 71, ch2);
        System.out.println(gf1);
        Human gm1 = new Human("баба Люда", true, 65, ch2);
        System.out.println(gm1);
        Human gf2 = new Human("дед Кирилл", true, 75, ch3);
        System.out.println(gf2);
        Human gm2 = new Human("баба Лада", true, 65, ch3);
        System.out.println(gm2);


    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
