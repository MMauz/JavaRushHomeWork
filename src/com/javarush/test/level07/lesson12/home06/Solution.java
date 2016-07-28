package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human granF1 = new Human("Дед Кусто", true, 75, null, null);
        Human granF2 = new Human("Дед Пихто", true, 73, null, null);
        Human granM1 = new Human("Баба Клава", false, 65, null, null);
        Human granM2 = new Human("Баба Дунька", false, 63, null, null);
        Human father = new Human("Отец Морфий", true, 40, granF1, granM1);
        Human mother = new Human("Мать Троица", false, 30, granF2, granM2);
        Human child1 = new Human("Дочь Эпл", false, 10, father, mother);
        Human child2 = new Human("Дочь Фак", false, 10, father, mother);
        Human child3 = new Human("Сын Нео", true, 7, father, mother);

        System.out.println(granF1);
        System.out.println(granF2);
        System.out.println(granM1);
        System.out.println(granM2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
