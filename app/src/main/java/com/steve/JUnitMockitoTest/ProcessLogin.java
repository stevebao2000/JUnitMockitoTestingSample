package com.steve.JUnitMockitoTest;

import android.util.Log;

public class ProcessLogin {
    // regular expressin to verify username and password. Customize for your peoduct.
    // start with non-digit. Followed by chars or digits
    String nameExp = "\\G[\\w&&\\D]\\w*";
    // mix of digits and chars.
    String passwordExp = "\\G[\\w]*";

    RemoteService service;

    public ProcessLogin(RemoteService service) {
        this.service = service;

    }
    public boolean UserLogin(String name, String password) {
        if (!validUserName(name)) return false;
        if (!validPassword(password)) return false;

        return service.Login(name, password);
    }

    public boolean validUserName(String name) {
        if (name == null) return false;
        if (name.length() < 3) return false;

        if (name.matches(nameExp)) {
           // Log.e("Login", "valid User Name");
            return true;
        }
        return false;
    }

    public boolean validPassword(String password) {
        if (password == null) return false;
        if (password.length() < 6) return false;

        if (password.matches(passwordExp)) {
           // Log.e("Login", "valid Password");
            return true;
        }
        return false;
    }
}
