package com.sayo.girl.config;

import com.sayo.girl.domain.User;
import com.sayo.girl.domain.UserContext;
import com.sayo.girl.repository.UserRepository;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * This is a custom class of org.springframework.security.ldap.userdetails.LdapUserDetailsMapper.<br>
 * User, function point and role information would not be retrieved from LDAP server. <br>
 * These information would be retrieved from local database.
 */
@Service("customUserDetailsMapper")
public class CustomUserDetailsMapper extends LdapUserDetailsMapper {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
                                          Collection<? extends GrantedAuthority> authority) {
        // Create original user object from LDAP server
        UserDetails originalUser = super.mapUserFromContext(ctx, username, authority);
        UserContext newUser = null;

        // Retrieve user, function point and role information from local database
        User user = userRepository.findByUserName(username);
        if (user != null) {
            if (!user.getEnableFlag()) {
//                throw new ApplicationException("LAN ID or Password is incorrect.")
//                        .addMessage("security.maintain_user.auth_fail",
//                                new Object[]{username});
            }
            newUser =
                    new UserContext(
                            originalUser.getUsername(),
                            originalUser.getPassword(),
                            originalUser.isEnabled(),
                            originalUser.isAccountNonExpired(),
                            originalUser.isCredentialsNonExpired(),
                            originalUser.isAccountNonLocked(),
                            authority);

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
