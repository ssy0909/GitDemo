package org.example.demo1.service;

import org.example.demo1.entity.Admin;

import java.util.List;


public interface AdminService {

    List<Admin> getAdmin(Admin admin);

    boolean getAdminByUsername(Admin admin);

    void addAdmin(Admin admin);
}
