package com.revature.Controller;


import com.revature.App;
import com.revature.Models.ReimbursementDTO;
import com.revature.Models.Reimbursement;
import com.revature.Models.ReimbStatus;
import com.revature.utils.Role;
import com.revature.utils.Status;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.Service.ReimbursementService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;


public class ReimbursementController implements Controller{

    private ReimbursementService reimbursementService = new ReimbursementService();


    Handler getAllReimbursements = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(reimbursementService.getAllReimbursements());

            ctx.status(200);
        }else {
            log.warn("Error. Invalid session.");
            ctx.status(401);
        }
    };

    Handler getReimbursementById = ctx ->{
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("userid");
            try {
                int id = Integer.parseInt(idString);
                Reimbursement reimbursement = reimbursementService.getReimbursementById(id);
                ctx.json(reimbursement);
                ctx.status(200);
            }catch(NumberFormatException e){
                e.printStackTrace();
                ctx.status(400);
            }


        }else{
            log.warn("Error. Invalid session.");
            ctx.status(401);
        }
    };

    Handler updateReimbursement = (ctx) -> {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement = ctx.bodyAsClass(Reimbursement.class);

        if(ctx.req.getSession(false) != null) {
            ctx.json(reimbursementService.updateReimbursement(reimbursement));
            ctx.status(200);
        }else{
            log.warn("Error. Invalid session.");
            ctx.status(401);
        }
    };

    Handler getReimbursementsByAuthor = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("author");
            try {

                int id = Integer.parseInt(idString);
                List list = new ArrayList<Reimbursement>();
                list = reimbursementService.getReimbursementsByAuthor(id);
                ctx.json(list);
                ctx.status(200);
            }catch(NumberFormatException e){
                e.printStackTrace();
                ctx.status(400);
            }
        }else{
            log.warn("Error. Invalid session.");
            ctx.status(401);
        }

    };

    //needs a session tracker
    Handler addReimbursement = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
            if(reimbursementService.addReimbursement(reimbursement)){
                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else{
            ctx.status(401);
        }


    };

    //needs as session tracker
    Handler deleteReimbursement = ctx -> {
        if (ctx.req.getSession(false) != null){
            int id = Integer.parseInt(ctx.pathParam("id"));
            if(reimbursementService.deleteReimbursement(id)){
                ctx.status(200);
            }else{
                ctx.status(400);
            }

        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }

    };

    Handler getAllReimbursementsByStatus = ctx -> {
        if(ctx.req.getSession(false)!=null) {
            String idString = ctx.pathParam("status");
            try {

                int id = Integer.parseInt(idString);
                List list = new ArrayList<Reimbursement>();
                list = reimbursementService.getAllReimbursementsByStatus(id);
                ctx.json(list);
                ctx.status(200);
                System.out.println("list");
            }catch(NumberFormatException e){
                e.printStackTrace();
                log.warn("Error. Invalid Entry.");
                ctx.status(400);
            }


        }else{
            log.warn("Error. Invalid session.");
            ctx.status(401);
        }

    };







    @Override
    public void addRoutes(Javalin app) {
        app.get("/reimbursments", getAllReimbursements, Role.EMPLOYEE);
        app.get("/reimbursments/user/{userid}", getReimbursementById, Role.EMPLOYEE);
        app.put("/reimbursments/user/update", updateReimbursement, Role.MANAGER);
        app.get("/reimbursments/user/{author}", getReimbursementsByAuthor, Role.EMPLOYEE);
        app.post("/reimbursments/add", addReimbursement, Role.EMPLOYEE);
        app.post("/reimbursements/delete/{id}", deleteReimbursement, Role.MANAGER);
        app.get("/reimbursments/user/{status}", getAllReimbursementsByStatus, Role.MANAGER);

    }
}
