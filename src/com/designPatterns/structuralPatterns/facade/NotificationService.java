package com.designPatterns.structuralPatterns.facade;

public class NotificationService {
    public void send(String message, String target) {
        NotificationServer server = new NotificationServer();
        Connection connection = server.connect("ip");
        AuthToken authToken = server.authenticate("an app", "with a key");
        server.send(authToken, new Message("Hello World"), target);
        connection.disconnect();
    }
}
