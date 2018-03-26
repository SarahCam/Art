package controllers;

import org.dom4j.rule.Mode;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static spark.Spark.get;

public class LoginController {

    public LoginController() {
        this.setupEndPoints();
    }

    private void setupEndPoints(){
        post("/login",  (req, res) -> {
            String username = req.queryParams("username");
            req.session().attribute("username", username);
            res.redirect("/articles/dashboard");
            return null;
        }, new VelocityTemplateEngine());

        get("/login", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/login.vtl");
        }, new VelocityTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().removeAttribute("username");
            res.redirect("/login");
            return null;
        }, new VelocityTemplateEngine());
    }


    public static String getLoggedInUserName(Request req, Response res){
        String username = req.session().attribute("username");
        if (username == null || username.isEmpty()){
            res.redirect("/login");
        }
        return username;
    }
}
