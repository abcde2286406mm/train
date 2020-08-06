package com.ucarinc.wtf.service;

import com.ucarinc.wtf.bean.Permission;
import com.ucarinc.wtf.bean.Role;
import com.ucarinc.wtf.bean.User;

import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.service
 * @ClassName: UserService
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/2/19 15:46
 * @Version: 1.0
 */
public interface UserService {
    List<Role> getRoleByUserId(Integer id);
    List<Permission> getPerMissionByUserId(Integer id);
    User getUserById(Integer id);
}
