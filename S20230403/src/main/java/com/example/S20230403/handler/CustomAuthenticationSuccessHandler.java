package com.example.S20230403.handler;

import com.example.S20230403.auth.PrincipalDetail;
import com.example.S20230403.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final UsersService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        PrincipalDetail userDetail = (PrincipalDetail) authentication.getPrincipal();
        String userId = userDetail.getUser().getUser_id();
        if (userService.isNewUser(userId) == 1) {
            response.sendRedirect("/additional-info");
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
