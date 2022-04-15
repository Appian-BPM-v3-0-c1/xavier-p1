package com.revature.contact.services;

import com.revature.contact.daos.DepartmentDAO;

public class DepartmentService {
    private final DepartmentDAO departmentDAO;


    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;

    }



    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }
}
