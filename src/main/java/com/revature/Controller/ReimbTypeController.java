package com.revature.Controller;

import com.revature.Models.ReimbStatus;
import com.revature.Models.ReimbType;
import com.revature.Service.TypeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbTypeController implements Controller{

    TypeService typeService = new TypeService();


    Handler getAllTypes = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(typeService.getAllTypes());
            log.info("Got all Types.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler getTypeByID = ctx ->{
        if(ctx.req.getSession(false)!=null){
            String idString = ctx.pathParam("typeid");
            try {
                int id = Integer.parseInt(idString);
                ReimbType type = typeService.getTypeByID(id);
                ctx.json(type);
                ctx.status(200);
            }catch(NumberFormatException e){
                e.printStackTrace();
                ctx.status(400);
            }


        }else{
            ctx.status(401);
        }
    };

    Handler addType = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ReimbType type = ctx.bodyAsClass(ReimbType.class);
            ctx.json(typeService.addType(type));
            log.info("Added Type.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler deleteType = ctx -> {
        if(ctx.req.getSession(false)!=null){

            try{
                int id = Integer.parseInt(ctx.pathParam("id"));
                if(typeService.deleteType(id)){
                    ctx.status(200);
                }else{
                    ctx.status(400);
                }



            }catch (NumberFormatException e){
                e.printStackTrace();
                log.warn("Invalid Entry");
            }


        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }

    };



    @Override
    public void addRoutes(Javalin app) {
        app.get("/type/get_all_type", getAllTypes);
        app.post("/type/get_by_id/{id}", getTypeByID);
        app.post("/type/add", addType);
        app.post("/type/delete/{id}", deleteType);


    }
}
