package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Student tom = new Student("Tom");
        Student john = new Student("John");
        Mentor mentorFrank = new Mentor("Frank");
        Mentor mentorWill = new Mentor("Will");
        Mentor mentorIvone = new Mentor("Ivone");
        tom.registerObserver(mentorFrank);
        john.registerObserver(mentorWill);
        tom.registerObserver(mentorIvone);
        john.registerObserver(mentorIvone);
        //When
        tom.submitExerciseForReview("Exercise 1");
        tom.submitExerciseForReview("Exercise 2");
        john.submitExerciseForReview("Exercise 3");
        john.submitExerciseForReview("Exercise 4");
        john.submitExerciseForReview("Exercise 5");
        //Then
        assertEquals(2, mentorFrank.theNumberOfExercisesToCheck());
        assertEquals(3, mentorWill.theNumberOfExercisesToCheck());
        assertEquals(5, mentorIvone.theNumberOfExercisesToCheck());
    }

}