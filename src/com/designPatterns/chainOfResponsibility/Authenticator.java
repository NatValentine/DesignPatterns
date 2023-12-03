package com.designPatterns.chainOfResponsibility;

public class Authenticator extends  Handler {
    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        boolean isValid = (request.getUsername() == "admin" &&
                request.getPassword() == "1234");

        if (isValid)
            System.out.println("Authenticated");
        else System.out.println("Incorrect username or password");

        return !isValid;
    }
}
