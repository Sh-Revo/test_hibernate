package com.shandov.project1jdbc.service;


import com.shandov.project1jdbc.dao.CompaniesDAO;
import com.shandov.project1jdbc.domain.Companies;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;


@RequiredArgsConstructor
public class CompaniesService {

    private final CompaniesDAO companiesDAO;



    public Companies findCompaniesById(Long id){

        return companiesDAO.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Company not found by id "+ id));
    }
}
