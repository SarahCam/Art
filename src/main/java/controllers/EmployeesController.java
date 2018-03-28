package controllers;

import db.DBHelper;
import models.Article;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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

    }
}
