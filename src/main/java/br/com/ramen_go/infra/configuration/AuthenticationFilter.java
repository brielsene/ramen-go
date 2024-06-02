package br.com.ramen_go.infra.configuration;

import br.com.ramen_go.dtos.ErrorApiKeyDto;
import br.com.ramen_go.infra.exceptions.ErrorApiKeyException;
import br.com.ramen_go.services.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {


        try {
                Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (ErrorApiKeyException exp) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                SecurityContextHolder.clearContext();
              // Create the DTO
        ErrorApiKeyDto errorDto = new ErrorApiKeyDto(exp.getMessage());

        // Convert the DTO to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(errorDto);

        // Write the JSON to the response
        PrintWriter writer = httpResponse.getWriter();
        writer.print(json);
        writer.flush();
        writer.close();

            }

            filterChain.doFilter(request, response);
    }
}
