package com.revature.Controller;


import com.revature.App;
import com.revature.Models.ReimbursementDTO;
import com.revature.Models.Reimbursement;
import com.revature.Models.ReimbStatus;
import com.revature.utils.Status;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.Service.ReimbursementService;

import java.util.ArrayList;
import java.util.List;


public class ReimbursementController implements Controller{

    private ReimbursementService reimbursementService = new ReimbursementService();


    Handler getAllReimbursements = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(reimbursementService.getAllReimbursements());

            ctx.status(200);
        }else {
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
            ctx.status(401);
        }

    };

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

    Handler deleteReimbursement = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if(reimbursementService.deleteReimbursement(id)){
            ctx.status(200);
        }else{
            ctx.status(400);
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
            }catch(NumberFormatException e){
                e.printStackTrace();
                ctx.status(400);
            }


        }else{
            ctx.status(401);
        }

    };







    @Override
    public void addRoutes(Javalin app) {
        app.get("/reimbursments", getAllReimbursements);
        app.get("/reimbursments/user/{userid}", getReimbursementById);
        app.put("/reimbursments/user/update", updateReimbursement);
        app.get("/reimbursments/user/{author}", getReimbursementsByAuthor);
        app.post("/reimbursments/add", addReimbursement);
        app.delete("/reimbursements/delete/{id}", deleteReimbursement);
        app.get("/reimbursments/user/{status}", getAllReimbursementsByStatus);


    }
}