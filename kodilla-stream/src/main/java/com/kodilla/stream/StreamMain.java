package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import static jdk.nashorn.internal.objects.NativeString.replace;
import static jdk.nashorn.internal.objects.NativeString.substring;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Mam na imię Katarzyna",string -> {
            char[] chars = string.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    chars[i] = '-';
                }
            }
            return chars.toString().replace(",", "*");
        });
        poemBeautifier.beautify("Mam na imię Katarzyna",string -> toUpperCase(string) );
        poemBeautifier.beautify("Mam na imię Katarzyna",string -> "ABC"+string+"ABC" );
        poemBeautifier.beautify("Mam na imię Katarzyna",string -> string.replace('a','A'));

        }
    }




