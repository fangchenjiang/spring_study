package com.gz.fangcj.controller;

import com.gz.fangcj.common.CommonResult;
import com.gz.fangcj.dto.PageDTO;
import com.gz.fangcj.entity.Role;
import com.gz.fangcj.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Fang chenjiang
 * @Date 2021/1/20
 */
@Api(tags = "RoleController", value = "角色管理")
@RequestMapping("/role")
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;
    @ApiOperation("角色分页列表")
    @RequestMapping(value = "/listPage",method = RequestMethod.GET)
    public CommonResult<PageDTO<Role>>getRolePage(@RequestParam(value = "currentPage",defaultValue = "1")Integer cuurrentPage,
                                                  @RequestParam(value = "pageSize",defaultValue = "20")Integer pageSize){

        PageDTO<Role> roleListPage = roleService.getRoleListPage(cuurrentPage, pageSize);
        return CommonResult.success(roleListPage);
    }
}
