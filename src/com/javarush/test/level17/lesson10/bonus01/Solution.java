package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        //start here - начни тут
        if (args[0].equals("-c"))
        {
            create(args[1], args[2], args[3]);
        } else if (args[0].equals("-u"))
        {
            update(args[1], args[2], args[3], args[4]);
        } else if (args[0].equals("-d"))
        {
            delete(args[1]);
        } else if (args[0].equals("-i"))
        {
            read(args[1]);
        }
    }

    public static Date stringToDate(String string)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try
        {
            date = format.parse(string);
        }
        catch (ParseException e)
        {
            System.out.printf("Incorrect date format: %s\n", e);
            ;
        }
        return date;
    }

    public static String dateToString(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return df.format(date);
    }

    public static void create(String name, String sex, String date)
    {
        Person person = null;
        if (sex.equals("м"))
        {
            person = Person.createMale(name, stringToDate(date));
        } else if (sex.equals("ж"))
        {
            person = Person.createFemale(name, stringToDate(date));
        }
        allPeople.add(person);
    }

    public static void update(String id, String name, String sex, String date)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        if (sex.equals("м"))
        {
            person.setSex(Sex.MALE);
        } else if (sex.equals("ж"))
        {
            person.setSex(Sex.FEMALE);
        }
        person.setBirthDay(stringToDate(date));
    }

    public static void delete(String id)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public static void read(String id)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.printf("%s %s %s\n",
                person.getName(), person.getSex().name().equals("MALE") ? "м" : "ж",
                dateToString(person.getBirthDay()));
    }
}
