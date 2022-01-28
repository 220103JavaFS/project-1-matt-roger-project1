package com.revature.Models;

import com.revature.utils.Status;

public class ReimbStatus {
    private int reimbStatusID;
    private Status status;

    public ReimbStatus() {
    }

    public ReimbStatus(int reimbStatusID, Status status) {
        this.reimbStatusID = reimbStatusID;
        this.status = status;
    }


    public int getReimbStatusID() {
        return reimbStatusID;
    }

    public Status getStatus() {
        return status;
    }

    public void setReimbStatusID(int reimbStatusID) {
        this.reimbStatusID = reimbStatusID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReimbStatus{" +
                "reimbStatusID=" + reimbStatusID +
                ", status=" + status +
                '}';
    }
}
