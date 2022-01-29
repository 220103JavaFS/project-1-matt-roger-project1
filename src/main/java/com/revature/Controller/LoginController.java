package com.revature.Controller;

import com.revature.Models.User;
import com.revature.Models.UserDTO;
import com.revature.Service.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import static com.revature.Models.EncryptionSHA.getSHA;
import static com.revature.Models.EncryptionSHA.toHexString;


public class LoginController implements Controller{

    LoginService loginService = new LoginService();

    private Handler login = (ctx) -> {
        UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);
        User user = new User();

        userDTO.password = toHexString(getSHA(userDTO.password));
        user = loginService.login(userDTO);
        if(userDTO != null)
        {
            ctx.req.getSession().setAttribute("accessLevel", user.getUserRoleId());
            log.info("Login successful");
            ctx.status(200);
        }else
        {
            ctx.req.getSession().invalidate();
            log.warn("Login failed.");
            ctx.status(401);
        }
    };


    private Handler logout = (ctx) -> {
        ctx.req.getSession().invalidate();
        log.info("Session logged out.");
        ctx.status(200);
    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/logout", logout);
        app.post("/login", login);
    }
}
