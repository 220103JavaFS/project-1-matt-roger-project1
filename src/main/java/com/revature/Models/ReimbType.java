package com.revature.Models;

import com.revature.utils.Type;

public class ReimbType {
    private int id;
    private Type type;


    public ReimbType() {
    }

    public ReimbType(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReimbType{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
