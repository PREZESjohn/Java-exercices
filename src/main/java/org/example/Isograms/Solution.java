package org.example.Isograms;

/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive.
Implement a function that determines whether a string that contains only letters is an isogram.
Assume the empty string is an isogram. Ignore letter case.
 */

public class Solution {
    public boolean solution(String S) {

        return  S.length()==S.toLowerCase().chars().distinct().count();
    }
}
