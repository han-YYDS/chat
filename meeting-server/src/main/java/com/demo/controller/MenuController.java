package com.demo.controller;


import com.demo.dto.UserMenuDTO;
import com.demo.entity.Menu;
import com.demo.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/system/cfg")
@Api(tags = "菜单模块")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "通过角色查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> gentMenusByAdminId(){
        return menuService.getMenusWithRole();
    }
    /**
     * 查看当前用户菜单
     *
     * @return  菜单列表
     */
    @ApiOperation(value = "查看当前用户查询菜单")
    @GetMapping("/user/menus")
    public List<UserMenuDTO> listUserMenus() {
        return menuService.listUserMenus();
    }

}

