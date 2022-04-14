package com.revature.contact.services;

import com.revature.contact.daos.DepartmentDAO;
import com.revature.contact.daos.LocationDAO;

public class LocationService {
    private final LocationDAO locationDAO;
    private final DepartmentDAO departmentDAO;


    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public LocationDAO getLocationDAO() {
        return locationDAO;
    }
}
