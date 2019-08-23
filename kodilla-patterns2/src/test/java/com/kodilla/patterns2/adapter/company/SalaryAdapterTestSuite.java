package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Assert;
import org.junit.Test;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter adapter = new SalaryAdapter();
        //When
        double totalSalary = adapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println(totalSalary);
        Assert.assertEquals(27750, totalSalary, 0);
    }
}
