package com.revature.DAO;

import com.revature.Models.ReimbType;
import com.revature.utils.Type;

import java.util.List;

public interface ReimbTypeDAO {

    public List<ReimbType> getAllTypes();
    public ReimbType getTypeByID(int id);
    public boolean addType(ReimbType newType);
    public boolean deleteType(int id);
}
