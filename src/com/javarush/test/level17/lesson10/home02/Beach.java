package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.Set;
import java.util.TreeSet;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        int resultQA = Integer.compare(this.getQuality(), o.getQuality());
        int resultDist = Float.compare(this.getDistance(), o.getDistance());
        int resultName = this.getName().compareTo(o.getName());

        return resultQA*1 + resultDist*10 + resultName*100;
    }


    public static void main (String[] args) {
        Set<Beach> set = new TreeSet<>();
        set.add(new Beach("beach1", 12f, 5));
        set.add(new Beach("beach2", 9f, 4));
        set.add(new Beach("beach3", 2f, 5));
        set.add(new Beach("beach4", 15f, 2));
        set.add(new Beach("beach5", 15f, 2));
        for (Beach beach: set)
        {
            System.out.printf("Name:%s Dist:%.2f QA:%d\n", beach.getName(), beach.getDistance(), beach.getQuality());
        }
    }

}
