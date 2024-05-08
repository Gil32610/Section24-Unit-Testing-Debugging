package dev.lpa.challenge;

import java.util.Stack;

public class Utilities {
    public char[] everyNthInt(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) return sourceArray;
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    public String removePairs(String source) {
        if (source.length() < 2) return source;
        Stack<Character> result =new Stack<>();
        result.push(source.charAt(0));
        for (int i = 1; i < source.length(); i++) {
            if(result.peek() != source.charAt(i)){
                result.push(source.charAt(i));
            }

        }
        StringBuilder resultStringBuilder = new StringBuilder();
        while(!result.isEmpty()){
            resultStringBuilder.append(result.pop());
        }

        return resultStringBuilder.reverse().toString();
    }

    public int converter (int a, int b){
        return (a/b) * (a*30) -2;
    }

    public String nullIfOddLength(String source){
        if(source.length()%2==0) return  source;
        return null;
    }
}
