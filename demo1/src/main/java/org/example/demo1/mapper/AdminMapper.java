package org.example.demo1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.demo1.entity.Admin;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> getAdmin(Admin admin);

    List<Admin> getAdminByUsername(Admin admin);

    void addAdmin(Admin admin);
}
