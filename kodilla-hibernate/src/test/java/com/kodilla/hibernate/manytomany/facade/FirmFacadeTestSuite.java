package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirmFacadeTestSuite {
@Autowired
FirmFacade firmFacade;
@Autowired
EmployeeDao employeeDao;
@Autowired
CompanyDao companyDao;
    @Test
    public void TestFetchEmployeesByParametr(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee lindaSmith = new Employee("Linda", "Smith");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(lindaSmith);
        //When
        List<Employee> employeesWithTh = firmFacade.FetchEmployeesByParametr("th");
        //Then
        Assert.assertEquals(2, employeesWithTh.size());
        //CleanUp
        try {
            employeeDao.delete(1);
            employeeDao.delete(2);
            employeeDao.delete(3);
            employeeDao.delete(4);

        } catch (Exception e) {
            // do nothing
        }
    }
    @Test
    public void TestFetchCompaniesByParameter(){
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        //When
        List<Company> companiesWithMa = firmFacade.FetchCompaniesByParametr("Ma");

        //Then
        Assert.assertEquals(2,companiesWithMa.size());

        //CleanUp
        try {
            employeeDao.delete(1);
            employeeDao.delete(2);
            employeeDao.delete(3);
        } catch (Exception e) {
            //do nothing
        }
    }
    }

