package com.studentService.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;


@Configuration
public class FilterConfig extends OncePerRequestFilter {


    Logger logger= LoggerFactory.getLogger(FilterConfig.class);

    // Allow common safe URL path characters according to RFC 3986
    private static final Pattern SAFE_URI_PATTERN = Pattern.compile("^[a-zA-Z0-9/_\\-\\.]*$");

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
            logger.error("working!!------------------------------------------------");
        try {
            String requestUri = request.getRequestURI();

            // Detect raw % characters that are not encoded properly
            if (requestUri.contains("%")) {
                throw new IllegalArgumentException("Illegal '%' character in URL");
            }

            // Decode URI safely
            String decodedUri = URLDecoder.decode(requestUri, StandardCharsets.UTF_8);

            // Validate against safe pattern
            if (!SAFE_URI_PATTERN.matcher(decodedUri).matches()) {
                throw new IllegalArgumentException("Invalid characters detected in URL: " + decodedUri);
            }

            // Log valid URL
            System.out.println("Processing URL: " + decodedUri);

            // Proceed with normal filter chain
            filterChain.doFilter(request, response);

        } catch (IllegalArgumentException ex) {
            // Log and return a clean JSON error response
            System.err.println("Blocked malformed URL: " + ex.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"" + ex.getMessage() + "\"}");
        }
    }
}
