package com.sayo.girl.service;

import com.sayo.girl.domain.UserRole;
import com.sayo.girl.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shuangyao
 * 22:36 2018/8/28
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional
    public boolean addNewUserRole(UserRole userRole) {

        userRoleRepository.save(userRole);

        return true;
    }
}
