package ru.netology.authorization_service.model;

public class Credentials {
    private String username;
    private String password;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Credentials credentials) {
        if (credentials.getUsername().equals(this.username) && credentials.getPassword().equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}
