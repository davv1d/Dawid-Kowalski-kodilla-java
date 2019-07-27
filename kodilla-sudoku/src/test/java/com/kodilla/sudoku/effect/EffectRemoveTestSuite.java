package com.kodilla.sudoku.effect;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.Position;
import com.kodilla.sudoku.dto.Tuple;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EffectRemoveTestSuite {

    @Test
    public void testEffect() {
        //Given
        SudokuElement element = new SudokuElement(SudokuElement.EMPTY, new Position(0, 0));
        Set<Integer> remove = new HashSet<>(Arrays.asList(1, 2, 9, 7));
        Tuple<SudokuElement, Set<Integer>> tuple = new Tuple<>(element, remove);
        //When
        Effect effect = new EffectRemove(tuple);
        Tuple<SudokuElement, Boolean> result = effect.effect();
        //Then
        Assert.assertEquals(Arrays.asList(3,4,5,6,8), result._1.getPossibleValues());
        Assert.assertTrue(result._2);
    }
}
