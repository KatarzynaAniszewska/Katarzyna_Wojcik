package com.kodilla.testing;

import java.util.ArrayList;

public class OddNumbersExterminator {
    ArrayList<Integer> evenNumberList;

    public OddNumbersExterminator() {
        evenNumberList = new ArrayList<Integer>();
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {


        for (int n = 0; n < numbers.size(); n++) {
            {
                int number = numbers.get(n);
                {
                    if (number % 2 == 0)
                        evenNumberList.add(number);

                }
            }
        }
        return evenNumberList;
    }
}



