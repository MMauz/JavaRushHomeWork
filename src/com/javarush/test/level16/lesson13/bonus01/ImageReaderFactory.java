package com.javarush.test.level16.lesson13.bonus01;


import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Чешир on 18.04.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes img) {

        ImageReader type;

        if (img == ImageTypes.BMP) type = new BmpReader();
        else if (img == ImageTypes.JPG) type = new JpgReader();
        else if (img == ImageTypes.PNG) type = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

        return type;

    }

}
