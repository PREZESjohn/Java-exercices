package org.example.LinkedIn.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Write your answer here, and then test your code.
// Your job is to implement the annotation and add it to the findAnswer() method.

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodDescription{
    String value();
}

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Add annotation to this method
    @MethodDescription("Finding the answer")
    public static void findAnswer() {

    }

}

// The implementation of the annotation goes here
