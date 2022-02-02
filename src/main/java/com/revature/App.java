package com.revature;

import com.revature.Controller.*;
import com.revature.Models.AccessManager;
import io.javalin.Javalin;


public class App {
    private static Javalin app;


    public static void main(String[] args) {

        app = Javalin.create(config -> {
            config.addStaticFiles(staticFiles -> {
                staticFiles.hostedPath = "/resources/static";
            });

            config.accessManager(new AccessManager());}); //This represents the configuration of the framework at runtime.
        configure(new UserController(), new ReimbursementController(), new LoginController(), new ReimbStatusController(), new ReimbTypeController());

        app.start();
    }

    public static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
