package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company,Integer> {
    List<Company>selectNameWithParam(@Param("NAMEPARAM") String nameParam);
    List<Company>selectCompanyNameWithParamToFacade(@Param("NAMEPARAM") String nameParam);


}
