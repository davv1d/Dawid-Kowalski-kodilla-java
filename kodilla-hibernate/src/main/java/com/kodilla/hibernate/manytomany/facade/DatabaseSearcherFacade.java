package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseSearcherFacade {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    public void retrieveEmployeesWhichIncludeInNameThisString(final String nameFragment) {
        String name = "%" + nameFragment + "%";
        List<Employee> employees = employeeDao.retrieveEmployeesWhichIncludeInNameThisString(name);
        if (employees.isEmpty()) {
            System.out.println("Not found employees");
        } else {
            System.out.println("Employees found");
            employees.forEach(employee -> System.out.println(employee.getFirstname() + " " + employee.getLastname()));
        }
    }

    public void retrieveCompaniesWhichIncludeInNameThisString(final String nameFragment) {
        String name = "%" + nameFragment + "%";
        List<Company> companies = companyDao.retrieveCompaniesWhichIncludeInNameThisString(name);
        if (companies.isEmpty()) {
            System.out.println("Not found companies");
        } else {
            System.out.println("Companies found");
            companies.forEach(company -> System.out.println(company.getId() + " " + company.getName()));
        }
    }
}
