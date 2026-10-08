package org.example.demo1.service.impl;

import ch.qos.logback.core.util.StringUtil;
import cn.hutool.core.collection.CollectionUtil;
import jakarta.annotation.Resource;
import org.example.demo1.entity.Admin;
import org.example.demo1.mapper.AdminMapper;
import org.example.demo1.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;


    @Override
    public List<Admin> getAdmin(Admin admin) {
        List<Admin> list = adminMapper.getAdmin(admin);

        return list;
    }

    @Override
    public boolean getAdminByUsername(Admin admin) {
        List<Admin> list = adminMapper.getAdminByUsername(admin);
        if(CollectionUtil.isEmpty(list)) {
            return true;
        }
        return false;
    }

    @Override
    public void addAdmin(Admin admin) {
        if(StringUtil.isNullOrEmpty(admin.getPassword())) {
            //密码为空时默认与用户名相同
            admin.setPassword(admin.getUsername());
        }
        adminMapper.addAdmin(admin);
    }
}
