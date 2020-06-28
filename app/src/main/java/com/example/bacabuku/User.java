package com.example.bacabuku;

public class User {
    public String user_id;
    public String Username;
    public String Password;
    public String id_akses;

    public User(String user_id, String Username, String Password, String id_akses) {
        this.user_id = user_id;
        this.Username = Username;
        this.Password = Password;
        this.id_akses = id_akses;
    }
}
