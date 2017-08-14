package kr.re.kitri.isrealboot.model;

import java.util.Collection;

/**
 *  클라이언트에 리턴해줄 값을 모아놓은 클래스 (접속한 사용자, 보유 권한, 요청할 때 필요한 token)
 */
public class AuthenticationToken {
    private String username;
    private Collection authorities;
    private String token;

    public AuthenticationToken() {
    }

    public AuthenticationToken(String username, Collection authorities, String token) {
        this.username = username;
        this.authorities = authorities;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthenticationToken{" +
                "username='" + username + '\'' +
                ", authorities=" + authorities +
                ", token='" + token + '\'' +
                '}';
    }
}
