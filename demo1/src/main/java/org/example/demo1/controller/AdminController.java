package org.example.demo1.controller;

import ch.qos.logback.core.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.demo1.common.Result;
import org.example.demo1.entity.Admin;
import org.example.demo1.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/getAdmin")
    public Result getAdmin(@RequestBody Admin admin) {
        PageHelper.startPage(admin.getPageNum(), admin.getPageSize());
        List<Admin> list = adminService.getAdmin(admin);

        PageInfo<Admin> page = new PageInfo<>(list);

        return Result.success(page);
    }

    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody Admin admin) {

        if(StringUtil.notNullNorEmpty(admin.getUsername()) && !Objects.equals(admin.getUsername(), null)) {
            if(adminService.getAdminByUsername(admin)) {
                adminService.addAdmin(admin);
                return Result.success(admin);
            } else {
                return Result.error("用户名已存在");
            }
        } else {
            return Result.error("用户名不能为空");
        }
    }

}
