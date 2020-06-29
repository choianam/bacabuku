package com.example.bacabuku.Model;

public class ModelProfil {

    String user_id, Username, Password, id_akses;

    public ModelProfil(){}

    public ModelProfil(String user_id, String Username, String Password, String id_akses ) {
        this.user_id = user_id;
        this.Username = Username;
        this.Password = Password;
        this.id_akses = id_akses;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String Password){ this.Password= Password; }

    public String getId_akses() {
        return id_akses;
    }

    public void setId_akses(String id_akses) {
        this.id_akses = id_akses;
    }
}
