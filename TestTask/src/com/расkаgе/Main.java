package com.расkаgе;

public class Main {
    public static void main(String[] args){

        int num = (int) (Math.random() * 1000);
        String link = "http://numbersapi.com/" + num + "/trivia";
        String fact = GetStrings.numFact(link);

        System.out.println("GET " + link);
        System.out.println(fact);

        System.out.println("Частоты:\n" + GetStrings.characterFrequency(fact));
        System.out.println("Среднее значение частоты " + GetStrings.averageFrequencyValue(fact));
        System.out.println("Символы, которые соответствуют условию наиболее близкого значения частоты к среднему значению: " +
                CountingCharacters.closeValue(fact));
    }
}
