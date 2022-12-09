package org.example;

// Rabin-Karp algorithm in Java

import java.util.ArrayList;

public class RabinKarp {
    String pattern;
    String text;
    int charNumber;
    int primeNumber;

    public RabinKarp(String pattern, String text) {
        this.pattern = pattern;
        this.text = text;
        this.charNumber = 256;
        this.primeNumber = 11;
    }

    public int hashText(String text, int hash, int i){
        return ((charNumber * hash + text.charAt(i)) % primeNumber);
    }

    public ArrayList<Integer> search() {
        final long startTime = System.nanoTime();

        int patternSize = pattern.length();
        int textSize = text.length();
        int patternHash = 0;
        int textHash = 0;
        int startIndex = 1;
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < patternSize - 1; i++)
            startIndex = (startIndex * charNumber) % primeNumber;

        for (int i = 0; i < patternSize; i++) {
            patternHash = hashText(pattern, patternHash, i);
            textHash = hashText(text,textHash, i);
        }

        int j;
        for (int i = 0; i <= textSize - patternSize; i++) {
            if (patternHash == textHash) {
                System.out.println(i+ ":  "+patternHash + "  "+ textHash);
                for (j = 0; j < patternSize; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == patternSize){
                    results.add(i+1);
                }
            }

            if (i < textSize - patternSize) {
                textHash = hashText(text, (textHash - text.charAt(i) * startIndex), i + patternSize);
                if (textHash < 0)
                    textHash = (textHash + primeNumber);
            }
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);
        return results;


    }


}
