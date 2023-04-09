package dev.ritik.movies.config;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoUserDetails implements UserDetails {

    private String username;
    private String password;

    public UserInfoUserDetails(UserInfo userInfo) {
        username = userInfo.getUsername();
        password = userInfo.getPassword();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<SimpleGrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> arrayList = new ArrayList<>();
        return arrayList;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
