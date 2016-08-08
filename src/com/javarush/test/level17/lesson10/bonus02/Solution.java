package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        //start here - начни тут
        if (args.length != 0)
        {
            if (args[0].equals("-c"))
            {
                int step = 3;
                int ids = (args.length - 1) / 3;
                for (int i = 0; i < ids; i++)
                {
                    create(args[1 + i * step], args[2 + i * step], args[3 + i * step]);
                }
            } else if (args[0].equals("-u"))
            {
                int step = 4;
                int ids = (args.length - 1) / 4;
                for (int i = 0; i < ids; i++)
                {
                    update(args[1 + i * step], args[2 + i * step], args[3 + i * step], args[4 + i * step]);
                }
            } else if (args[0].equals("-d"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    delete(args[i]);
                }
            } else if (args[0].equals("-i"))
            {
                for (int i = 1; i < args.length; i++)
                {
                    read(args[i]);
                }
            }
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

    public static synchronized void create(String name, String sex, String date)
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
        System.out.println(allPeople.indexOf(person));
    }

    public static synchronized void update(String id, String name, String sex, String date)
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

    public static synchronized void delete(String id)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public static synchronized void read(String id)
    {
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.printf("%s %s %s\n",
                person.getName(), person.getSex().name().equals("MALE") ? "м" : "ж",
                dateToString(person.getBirthDay()));
    }
}
