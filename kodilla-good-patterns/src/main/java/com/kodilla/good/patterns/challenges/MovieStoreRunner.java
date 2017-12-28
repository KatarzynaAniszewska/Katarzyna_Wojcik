package com.kodilla.good.patterns.challenges;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieStoreRunner {
    public static void main(String []args){
                MovieStore movieStore = new MovieStore();
       String titles = movieStore.getMovies().entrySet().stream()
               .map(x->x.getValue())
               .flatMap(x1->x1.stream())
               .collect(Collectors.joining("!","",""));
       System.out.println(titles);
    }

    }

