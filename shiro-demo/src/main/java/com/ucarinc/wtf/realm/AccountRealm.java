package com.ucarinc.wtf.realm;

import com.ucarinc.wtf.bean.Permission;
import com.ucarinc.wtf.bean.Role;
import com.ucarinc.wtf.bean.User;
import com.ucarinc.wtf.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.realm
 * @ClassName: AccountRealm
 * @Author: wtf
 * @Description:
 * @Date: 2019/9/3 12:49
 * @Version: 1.0
 */
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String uid = (String) principalCollection.getPrimaryPrincipal();
        List<Role> roles = userService.getRoleByUserId(Integer.parseInt(uid));
        Set<String> roleNames = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        authorizationInfo.setRoles(roleNames);

        List<Permission> permissions = userService.getPerMissionByUserId(Integer.parseInt(uid));
        Set<String> permissionNames = new HashSet<>(permissions.size());
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermissionName());
        }
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**这里为什么是String类型呢？其实要根据Subject.login(token)时候的token来的，你token定义成的pricipal是啥，这里get的时候就是啥。比如我
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken idEmail = new UsernamePasswordToken(String.valueOf(user.getId()), user.getEmail());
         try {
         idEmail.setRememberMe(true);
         subject.login(idEmail);
         }
         **/
        String uId = (String) authenticationToken.getPrincipal();
        User user = userService.getUserById(Integer.parseInt(uId));
        if (user == null) {
            return null;
        }
        //SimpleAuthenticationInfo还有其他构造方法，比如密码加密算法等，感兴趣可以自己看
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                uId,                      //表示凭证，可以随便设，跟token里的一致就行
                user.getEmail(),   //表示密钥如密码，你可以自己随便设，跟token里的一致就行
                getName()
        );
        //authenticationInfo信息交个shiro，调用login的时候会自动比较这里的token和authenticationInfo
        return authenticationInfo;
    }
}
