package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    private Facade facade;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindEmployees() {
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

        //When & Then

        facade.process("Sm", Facade.EMPLOYEES);

        employeeDao.deleteById(id1);
        employeeDao.deleteById(id2);
        employeeDao.deleteById(id3);
    }

    @Test
    public void testFindCompanies() {
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

        //When & Then
        facade.process("pa", Facade.COMPANIES);
        companyDao.deleteById(id1);
        companyDao.deleteById(id2);
        companyDao.deleteById(id3);
    }
}
