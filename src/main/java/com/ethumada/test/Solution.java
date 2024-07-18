package com.ethumada.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static List<String> generatePalindromes(String word) {
        Set<String> palindromeSet = new HashSet<>();

        generatePalindrome("", word.toLowerCase(), palindromeSet);
        return new ArrayList<>(palindromeSet);
    }

    private static void generatePalindrome(String leftPos, String rightPos, Set<String> result) {
        if (rightPos.isEmpty()) {
            if (isPalindrome(leftPos)) {
                result.add(leftPos);
            }
        } else {
            for (int i = 0; i < rightPos.length(); i++) {
                String nextLeftPos = leftPos + rightPos.charAt(i);
                String nextRightPos = rightPos.substring(0, i) + rightPos.substring(i + 1);
                generatePalindrome(nextLeftPos, nextRightPos, result);
            }
        }
    }

    public static boolean isPalindrome (String s){
        String strTransform = s.toLowerCase();
        int len = strTransform.length();

        int leftPosition = 0;
        int rightPosition = len - 1;

        while(leftPosition < rightPosition){
            if(strTransform.charAt(leftPosition) != strTransform.charAt(rightPosition)){
                return false;
            }
            leftPosition++;
            rightPosition--;
        }
        return true;
    }
    public static void main(String[] args) {
        String stringForExample = "Acca";
        List<String> listOfPalindromes = new ArrayList<>();

        boolean isPalindrome = false;
        isPalindrome =  isPalindrome(stringForExample);

        System.out.println("Entrée = "+stringForExample+ "; isPalindrome = "+isPalindrome);

        if(isPalindrome){
            listOfPalindromes = generatePalindromes(stringForExample);
            System.out.println("List of palindromes from "+stringForExample+ " : "+listOfPalindromes);
        }else{
            System.out.println("List of palindromes from "+stringForExample+ " : "+listOfPalindromes);
        }
    }

}
