package com.kodilla.hibernate.manytomany;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQueries({
        @NamedNativeQuery(name = "Company.selectNameWithParam",
                query = "SELECT * FROM COMPANIES" +
                        " WHERE SUBSTR(COMPANY_NAME,1,3) LIKE:'%NAMEPARAM%'",
                resultClass = Company.class
        ),

        @NamedNativeQuery(name = "Company.selectNameWithParamToFacade",
                query = "SELECT * FROM COMPANIES" +
                        " WHERE COMPANY_NAME LIKE:NAMEPARAM",
                resultClass = Company.class
        )
})
@Repository
@Entity
@Table(name="COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee>employees=new ArrayList<>();

    @ManyToMany(cascade =CascadeType.ALL,mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company(){
    }
    public Company(String name){
        this.name=name;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name= "COMPANY_ID",unique = true)
    public int getId() {
        return id;
    }
    @NotNull
    @Column(name="COMPANY_NAME")
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
