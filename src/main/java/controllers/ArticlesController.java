package controllers;

import db.DBHelper;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;

public class ArticlesController {
    public ArticlesController(){
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        get("/", (req, res) -> {
            List<Article> articles = DBHelper.getAll(Article.class);
            Map<String, Object> model = new HashMap<>();

            model.put("articles", articles);
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
