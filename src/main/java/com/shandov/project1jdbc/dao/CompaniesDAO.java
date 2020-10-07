package com.shandov.project1jdbc.dao;

import com.shandov.project1jdbc.domain.Companies;



public class CompaniesDAO extends GenericDAO<Companies, Long>{
    @Override
    public Class<Companies> getEntityClass() {
        return Companies.class;
    }



}
