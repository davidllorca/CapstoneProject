package me.davidllorca.trendingrepos.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntry {

    @PrimaryKey
    private long id;
    private String login;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
