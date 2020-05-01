package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/ads/register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("usernameInput");
        String password = request.getParameter("passwordInput");
        String email = request.getParameter("emailInput");
        // TODO: ensure the submitted information is valid
        if (isRegistrationValid(username, email, password)) {
            request.getRequestDispatcher("/WEB-INF/ads/register.jsp").forward(request, response);
        }
        // TODO: create a new user based off of the submitted information
        User user = new User(username, email, password);
        try {
            DaoFactory.getUsersDao().insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO: if a user was successfully created, send them to their profile
        response.sendRedirect("./profile.jsp");
    }
    private boolean isRegistrationValid(String username, String password, String email) {
        if (!isUsernameValid(username)) {
            return false;
        }
        if (!isPasswordValid(password)) {
            return false;
        }
        if (!isEmailValid(email)) {
            return false;
        }
        return true;
    }
    private boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSpecial = false; // e.g. (1-8 on keyboard)
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                hasNumber = true;
            }
            if ((password.charAt(i) >= 33 && password.charAt(i) <= 47) || password.charAt(i) == 64) {
                hasSpecial = true;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 90) {
                hasUpper = true;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                hasLower = true;
            }
            if (hasUpper && hasLower && hasNumber && hasSpecial) {
                return true;
            }
        }
        return false;
    }
    private boolean isUsernameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.length() < 10) {
            return false;
        }
        if (username.length() > 25) {
            return false;
        }
        Pattern pattern = Pattern.compile("[A-Za-z_][A-Za-z0-9_]+");
        if (!pattern.matcher(username).matches()) {
            return false;
        }
        return false;
    }
}