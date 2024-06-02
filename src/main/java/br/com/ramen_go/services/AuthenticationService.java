package br.com.ramen_go.services;

import br.com.ramen_go.configuration.ApiKeyAuthentication;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    @Value("${my.api.key}")
    private String myApiKey;

    private static String AUTH_TOKKEN;

    public static Authentication getAuthentication(HttpServletRequest request) {
        System.out.println("SUA API KEY É: "+getApiSecret());
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(getApiSecret())) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }

    @PostConstruct
    public void init(){
        AUTH_TOKKEN = myApiKey;
    }

    public static String getApiSecret(){
        return AUTH_TOKKEN;
    }
}
