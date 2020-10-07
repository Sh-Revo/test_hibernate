package com.shandov.project1jdbc;

import com.shandov.project1jdbc.dao.CompaniesDAO;
import com.shandov.project1jdbc.service.CompaniesService;

public class Main {

    private static final CompaniesService companiesService = new CompaniesService(new CompaniesDAO());

    public static void main(String[] args) {
        //companiesService.modifyData();
        //System.out.println(companiesService.getAllCompanies());
        System.out.println(companiesService.findCompaniesById(1L));
    }
}
