package com.revature.Controller;

import com.revature.App;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Controller {
    public static Logger log = LoggerFactory.getLogger(App.class);

    void addRoutes(Javalin app);

}
