package com.расkаgе;

public class CountingCharacters {

    public static int[] countCharacters(String fact){
        int[] cs = new int[128];

        int n = fact.length();
        for (int i = 0; i < n; i++){
            char symbol = fact.charAt(i);
            cs[(int) symbol]++;
        }
        return cs;
    }

    public static int totalCharacters(int[] cs){
        int total = 0;

        for (int i = 48; i < 128; i++){
            if (cs[i] != 0){
                total += cs[i];
            }
        }
        return total;
    }

    public static int variousCharacters(int[] cs){
        int various = 0;

        for (int i = 48; i < 128; i++){
            if (cs[i] != 0){
                various++;
            }
        }
        return various;
    }

    public static String closeValue(String fact){
        int[] cs = countCharacters(fact);
        int total = totalCharacters(cs);
        int various = variousCharacters(cs);
        double average = Math.round((double) total/various);
        StringBuilder cv = new StringBuilder();

        for (int i = 48; i < 128; i++){
            if (cs[i] == average){
                cv.append((char) i).append("(").append(i).append("),");
            }
        }
        return cv.substring(0, cv.length() - 1);
    }

}
