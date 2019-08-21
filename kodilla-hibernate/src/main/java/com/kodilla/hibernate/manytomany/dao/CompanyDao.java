package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Company> retrieveCompaniesWithFirstThreeLetterInNameIs(@Param("FIRSTLETTER") String firstThreeLetters);

    @Query
    List<Company> retrieveCompaniesWhichIncludeInNameThisString(@Param("NAMEFRAGMENT") String nameFragment);
}
