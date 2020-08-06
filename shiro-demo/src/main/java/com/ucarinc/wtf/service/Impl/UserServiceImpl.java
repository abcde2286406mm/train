package com.ucarinc.wtf.service.Impl;

import com.ucarinc.wtf.bean.*;
import com.ucarinc.wtf.dao.*;
import com.ucarinc.wtf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.service.Impl
 * @ClassName: UserServiceImpl
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/2/19 15:47
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<Role> getRoleByUserId(Integer id) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUidEqualTo(id);
        List<UserRole> userRoleList = userRoleMapper.selectByExample(example);
        List<Integer> roleIdList = new ArrayList<>(userRoleList.size());
        for (UserRole userRole : userRoleList) {
            roleIdList.add(userRole.getRoleId());
        }
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIn(roleIdList);
        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public List<Permission> getPerMissionByUserId(Integer id) {
        List<Role> roles = getRoleByUserId(id);
        List<Integer> roleIds = new ArrayList<>(roles.size());
        for (Role role : roles) {
            roleIds.add(role.getId());
        }
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<RolePermission> keyList = rolePermissionMapper.selectByExample(example);
        List<Integer> permissionIdList = new ArrayList<>(keyList.size());
        for (RolePermission rolePermissionKey : keyList) {
            permissionIdList.add(rolePermissionKey.getPermissionId());
        }
        PermissionExample permissionExample = new PermissionExample();
        if (permissionIdList.size() != 0) {
            permissionExample.createCriteria().andIdIn(permissionIdList);
            return permissionMapper.selectByExample(permissionExample);
        }
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
