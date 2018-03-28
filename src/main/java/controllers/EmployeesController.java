package controllers;

import db.DBHelper;
import enums.CategoryType;
import models.Article;
import models.Employee;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class EmployeesController {

    public EmployeesController(){
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        get("/employees/dashboard", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            List<Employee> employees = DBHelper.getAll(Employee.class);

            model.put("template", "templates/employees/edit.vtl");
            model.put("employees", employees);

            return new ModelAndView(model, "templates/adminLayout.vtl");
        }, new VelocityTemplateEngine());


        post ("/employees/dashboard", (req, res) -> {
            String firstName = req.queryParams("firstname");
            String lastName = req.queryParams("lastname");

            String strIsEmployed = req.queryParams("isemployed");
            Boolean boolIsEmployed = Boolean.parseBoolean(strIsEmployed);

            Employee thisEmployee = DBHelper.findEmployee(firstName);

            thisEmployee.setFirstName(firstName);
            thisEmployee.setLastName(lastName);
            thisEmployee.setEmployed(boolIsEmployed);

            DBHelper.saveOrUpdate(thisEmployee);
            res.redirect("/employees/dashboard");
            return null;

        }, new VelocityTemplateEngine());

    }
}
