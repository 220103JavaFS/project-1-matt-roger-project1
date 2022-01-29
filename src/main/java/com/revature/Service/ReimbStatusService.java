package com.revature.Service;

import com.revature.DAO.ReimbStatusDAO;
import com.revature.DAOImp.ReimbStatusDAOImpl;
import com.revature.Models.ReimbStatus;
import com.revature.Models.ReimbType;

import java.util.List;

public class ReimbStatusService {



    private ReimbStatusDAO reimbStatusDAO = new ReimbStatusDAOImpl();

    public List<ReimbStatus> getAllStatus(){
        return reimbStatusDAO.getAllStatus();
    }
    public ReimbStatus getStatusByID(int id){
        return reimbStatusDAO.getStatisByID(id);
    }
    public boolean addStatus(ReimbStatus newStatus){
        return reimbStatusDAO.addStatus(newStatus);
    }
    public boolean deleteStatus(int id){
        return reimbStatusDAO.deleteStatus(id);
    }
}
