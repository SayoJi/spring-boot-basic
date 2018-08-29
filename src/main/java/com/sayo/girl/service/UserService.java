package com.sayo.girl.service;

import com.sayo.girl.domain.User;
import com.sayo.girl.domain.UserRole;
import com.sayo.girl.repository.UserRepository;
import com.sayo.girl.repository.UserRoleRepository;
import com.sayo.girl.valueobject.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuangyao
 * 22:20 2018/8/28
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * save user.
     * @param userForm user info, include role code of this user.
     * @return true
     */
    @Transactional
    public boolean addUser(UserForm userForm) {
        User user = new User();
        user.setPassword(userForm.getPassword());
        user.setUserName(userForm.getUserName());
        user.setUserDescription(userForm.getUserDesc());
        user.setEnableFlag(true);

        List<UserRole> roleList = new ArrayList<>();
        UserRole userRole;
        for (String roleCode : userForm.getRoleCodeList()) {
            userRole = userRoleRepository.findOne(roleCode);
            if(userRole == null){
                //todo do something, throw exception
            }
            roleList.add(userRole);
        }
        user.setRoles(roleList);
        userRepository.save(user);
        return true;
    }
}
