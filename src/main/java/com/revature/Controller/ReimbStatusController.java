package com.revature.Controller;

import com.revature.Models.ReimbStatus;
import com.revature.Service.LoginService;
import com.revature.Service.ReimbStatusService;
import io.javalin.Javalin;

import io.javalin.Javalin;
import io.javalin.http.Handler;


public class ReimbStatusController implements Controller{

    ReimbStatusService reimbStatusService = new ReimbStatusService();

    Handler getAllStatus = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(reimbStatusService.getAllStatus());
            log.info("Got all Status.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler getStatisByID = ctx ->{
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("userid");
            try {
                int id = Integer.parseInt(idString);
                ReimbStatus status = reimbStatusService.getStatusByID(id);
                ctx.json(status);
                ctx.status(200);
            }catch(NumberFormatException e){
                e.printStackTrace();
                ctx.status(400);
            }


        }else{
            ctx.status(401);
        }
    };

    Handler addStatus = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ReimbStatus status = ctx.bodyAsClass(ReimbStatus.class);
            ctx.json(reimbStatusService.addStatus(status));
            log.info("Added Status.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler deleteStatus = ctx ->{

    };



    @Override
    public void addRoutes(Javalin app) {

    }
}
