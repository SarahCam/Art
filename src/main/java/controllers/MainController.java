package controllers;

import db.Seeds;
import enums.CategoryType;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        Spark.staticFileLocation("/public");

        Seeds.seedData();



        ArticlesController articlesController = new ArticlesController();
        LoginController loginController = new LoginController();


    }
}
