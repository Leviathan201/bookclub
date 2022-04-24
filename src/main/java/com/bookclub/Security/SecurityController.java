package com.bookclub.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {
    @RequestMapping(path = "/login", method = RequestMethod.GET) //Redirects users to the login page
    public String showLoginPage() {
        return "login"; //Shows login page
    }

    @RequestMapping(path = "/logout",  method = RequestMethod.GET) //User logout method that logsout the user when the user wants to
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); //Authenticates the user when trying to logout

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth); //Gets the response from the user
        }
        return "redirect:/login?logout=true"; //Redirects user to login page when user logs out
    }
}
