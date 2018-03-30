package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FirmFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> FetchEmployeesByParametr(String param){
        return employeeDao.selectEmployeesWithNameToFacade(param);
    }
    public List<Company> FetchCompaniesByParametr(String param){
        return companyDao.selectCompanyNameWithParamToFacade(param);
    }
}
