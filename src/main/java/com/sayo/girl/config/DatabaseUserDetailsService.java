package com.sayo.girl.config;

import com.sayo.girl.domain.User;
import com.sayo.girl.domain.UserContext;
import com.sayo.girl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("databaseUserDetailsService")
public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserContext newUser = null;

        // Retrieve user, function point and role information from local database
        User user = userRepository.findByUserName(username);
        if (user != null) {
            Boolean isEnable = user.getEnableFlag() == null ? Boolean.FALSE : user.getEnableFlag();

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
            newUser.setUserRolesList(userRepository.queryUserOwnedRoleCodes(username));
        } else {
//            throw new ApplicationException("User '" + username + "' is not exist.")
//                    .addMessage("security.maintain_user.not_existing_user",
//                            new Object[]{username});
        }
        return newUser;
    }
}
