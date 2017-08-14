package kr.re.kitri.isrealboot.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class Auth {
    private String username;
    private String authname;

    public Auth() {
    }
    public Auth(String username, String authname) {
        this.username = username;
        this.authname = authname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "username='" + username + '\'' +
                ", authname=" + authname +
                '}';
    }
}
