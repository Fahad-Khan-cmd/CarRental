package org.carrental.service;

import org.carrental.dao.UserDAO;
import org.carrental.domain.User;

public class AuhenticationService {
    private final UserDAO userDAO = new UserDAO();

    public Boolean checkLogin(String username, String password){
        User user = userDAO.getUserNameAndPassword(username,password);
        if(user != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
