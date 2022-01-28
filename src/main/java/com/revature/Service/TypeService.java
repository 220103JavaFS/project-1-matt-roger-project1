package com.revature.Service;

import com.revature.DAO.ReimbTypeDAO;
import com.revature.DAOImp.ReimbTypeDAOImpl;
import com.revature.Models.ReimbType;
import com.revature.Models.Reimbursement;
import com.revature.utils.Type;

import java.util.List;

public class TypeService {

    private ReimbTypeDAO reimbTypeDAO = new ReimbTypeDAOImpl();

    public List<ReimbType> getAllTypes(){
        return reimbTypeDAO.getAllTypes();
    }
    public ReimbType getTypeByID(int id){
        return reimbTypeDAO.getTypeByID(id);
    }
    public boolean addType(Type newType){
        return addType(newType);
    }
    public boolean deleteType(int id){
        return deleteType(id);
    }
}
