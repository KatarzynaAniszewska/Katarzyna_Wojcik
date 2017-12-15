package com.kodilla.stream.beautifier;
import java.lang.String;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class PoemBeautifier {
    public String beautify (String string, PoemDecorator poemDecorator){

            String result = poemDecorator.decorate(string);
              return result;
        }

    }


