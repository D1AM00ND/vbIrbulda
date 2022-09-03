package com.расkаgе;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetStrings {

    public static String numFact(String query){
        HttpURLConnection connection = null;

        try{
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }

                return sb.toString();
            } else {
                return "fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage();
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return "";
    }

    public static StringBuilder characterFrequency(String fact){
        int[] cs = CountingCharacters.countCharacters(fact);
        StringBuilder cf = new StringBuilder();

        int n = 128;
        for (int i = 48; i < n; i++){
            if (cs[i] != 0){
                cf.append((char) i).append(" - ").append(cs[i]);

                if (12 <= cs[i] % 100 && cs[i] % 100 <= 14){
                    cf.append(" раз\n");
                } else if(2 <= cs[i] % 10 && cs[i] % 10 <= 4) {
                    cf.append(" раза\n");
                } else {
                    cf.append(" раз\n");
                }
            }
        }
        return cf;
    }

    public static String averageFrequencyValue(String fact){
        int[] cs = CountingCharacters.countCharacters(fact);
        int total = CountingCharacters.totalCharacters(cs);
        int various = CountingCharacters.variousCharacters(cs);

        return total + "/" + various + " = " + (double) total / various;
    }
}
