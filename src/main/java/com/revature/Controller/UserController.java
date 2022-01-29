package com.revature.Controller;

import com.revature.DAO.UserDAO;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;
import com.revature.Service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class UserController implements Controller{

    private UserService userService = new UserService();

    Handler getByUsername = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            String username = ctx.pathParam("username");
            try {
                User user = userService.findByUsername(username);
                ctx.json(user);
                log.info("Got User.");
                ctx.status(200);
            }catch(NumberFormatException e){
                e.printStackTrace();
                log.warn("Invalid entry.");
                ctx.status(400);
            }
        }else{
            log.warn("Invalid session.");
            ctx.status(401);
        }

    };
    Handler getAllUsers = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(userService.getUsers());
            log.info("Got all Users.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler addUser = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            User newUser = ctx.bodyAsClass(User.class);
            ctx.json(userService.addUser(newUser));
            log.info("Added User.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler updateUser = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            User newUser = ctx.bodyAsClass(User.class);
            ctx.json(userService.updateUser(newUser));
            log.info("Updated User.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    Handler deleteUser = ctx ->{
        if(ctx.req.getSession(false)!=null) {
            String username = ctx.pathParam("username");
            ctx.json(userService.deleteUser(username));
            log.info("Deleted User.");
            ctx.status(200);
        }else {
            log.warn("Invalid session.");
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/users/delete_user/{username}", deleteUser);
        app.get("/user/add_user", addUser);
        app.get("/user/update_user", updateUser);
        app.get("/user/get_all_users", getAllUsers);
        app.get("/user/get_by_username/{username}", getByUsername);
    }
}

