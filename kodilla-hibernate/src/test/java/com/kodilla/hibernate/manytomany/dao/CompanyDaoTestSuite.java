package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testEmployeeNamedQuery() {
        //Given
        Employee employee1 = new Employee("Will", "Smith");
        Employee employee2 = new Employee("John", "Smith");
        Employee employee3 = new Employee("Mark", "Selby");

        employeeDao.save(employee1);
        int id1 = employee1.getId();
        employeeDao.save(employee2);
        int id2 = employee2.getId();
        employeeDao.save(employee3);
        int id3 = employee3.getId();

        //When
        List<Employee> resultList = employeeDao.retrieveEmployeesWithLastnameIs("Smith");
        List<Employee> list = employeeDao.retrieveEmployeesWhichIncludeInNameThisString("it");
        //Then
        try {
            Assert.assertEquals(2,resultList.size());
        } finally {
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        }
    }

    @Test
    public void testCompanyNamedNativeQuery() {
        //Given
        Company company1 = new Company("Company1");
        Company company2 = new Company("Computer company");
        Company company3 = new Company("Condition");

        companyDao.save(company1);
        int id1 = company1.getId();
        companyDao.save(company2);
        int id2 = company2.getId();
        companyDao.save(company3);
        int id3 = company3.getId();

        //When
        List<Company> companyList = companyDao.retrieveCompaniesWithFirstThreeLetterInNameIs("Com");

        //Then
        try {
            Assert.assertEquals(2, companyList.size());
        } finally {
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }
    }
}
