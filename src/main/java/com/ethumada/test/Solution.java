package com.ethumada.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static List<String> generatePalindromes(String s) {
        List<String> arrayListOfPalindromes = new ArrayList<>();

        Set<String> paliSet = new HashSet<>();
        generatePermutations("", s, paliSet);

        boolean isPali = isPalindrome(s);
        if(isPali){

            //
            generatePermutations("", s, paliSet);
            //

            return arrayListOfPalindromes;
        }else{
            return arrayListOfPalindromes;
        }

    }

    public static void generatePermutations(String prefix, String stringRestant, Set<String> res) {
        int nbRestant = stringRestant.length();
        if(nbRestant == 0){
            String reversedOf = new StringBuilder(prefix).reverse().toString();
        }else{
            for(int i = 0; i < nbRestant; i++){
                generatePermutations(prefix + stringRestant.charAt(i), stringRestant.substring(0, i), res);
            }
        }
    }

    public static boolean isPalindrome (String s){
        String strTransform = s.toLowerCase();
        int len = strTransform.length();

        int leftPosition = 0;
        int rightPosition = len - 1;

        while(leftPosition < rightPosition){
            System.out.println("leftPosition = "+leftPosition+ "; rightPosition = "+rightPosition);
            if(strTransform.charAt(leftPosition) != strTransform.charAt(rightPosition)){
                return false;
            }

            leftPosition++;
            rightPosition--;
        }
        return true;
    }

    public static void main(String[] args){
        String stringForExample = "Arra";
        boolean isPalindrome = false;
        isPalindrome =  isPalindrome(stringForExample);
        System.out.println("Entrée = "+stringForExample+ "; isPalindrome = "+isPalindrome);
        if(isPalindrome){
            List<String> list = new ArrayList<>();
            list = generatePalindromes(stringForExample);
            System.out.println("List of palindromes from "+stringForExample+ " : "+list);
        }
    }

}
