package com.revature.DAO;

import com.revature.Models.ReimbStatus;
import com.revature.Models.ReimbType;
import com.revature.utils.Status;
import com.revature.utils.Type;

import java.util.List;

public interface ReimbStatusDAO {

    public List<ReimbStatus> getAllStatus();
    public ReimbStatus getStatisByID(int id);
    public boolean addStatus(ReimbStatus newStatus);
    public boolean deleteStatus(int id);
}
