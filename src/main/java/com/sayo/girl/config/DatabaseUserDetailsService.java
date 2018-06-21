package com.sayo.girl.config;

import com.sayo.girl.domain.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("databaseUserDetailsService")
public class DatabaseUserDetailsService extends UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserContext newUser = null;

        // Retrieve user, function point and role information from local database
        User user = userRepository.findByUserName(username);
        if (user != null) {
            Boolean isEnable = Boolean.FALSE;
            if ("Active".equals(user.getStatus())) {
                isEnable = Boolean.TRUE;
            }


            newUser =
                    new UserContext(
                            user.getUserName(),
                            user.getPassword(),
                            isEnable,
                            Boolean.TRUE,
                            Boolean.TRUE,
                            Boolean.TRUE,
                            new ArrayList<GrantedAuthority>());
            newUser.setUser(user);
            newUser.setUserRolesList(userDao.queryUserOwnedRoleCodes(username));
            newUser.setUserFunctionPointsList(userDao.queryUserOwnedFunctionPointCodes(username));
        } else {
            throw new ApplicationException("User '" + username + "' is not exist.")
                    .addMessage("security.maintain_user.not_existing_user",
                            new Object[]{username});
        }
        return newUser;
    }
}
