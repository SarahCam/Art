package controllers;

import db.DBHelper;
import models.Employee;
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
            res.redirect("/dashboard");
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

        get("/dashboard", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);
            model.put("user", loggedInUser);
            model.put("loggedInEmployeeType", loggedInEmployeeType);
            return new ModelAndView(model, "templates/redirectLayout.vtl");
        }, new VelocityTemplateEngine());
    }


    public static String getLoggedInUserName(Request req, Response res){
        String username = req.session().attribute("username");
        Employee loggedInEmployee = DBHelper.findEmployee(username);
        if (username == null || username.isEmpty() || loggedInEmployee == null || !loggedInEmployee.isEmployed()){
            res.redirect("/login");
        }
        return username;
    }
}
