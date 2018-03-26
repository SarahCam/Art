package controllers;

import db.DBHelper;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;

public class ArticlesController {
    public ArticlesController(){
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Article> articles = DBHelper.getAll(Article.class);

            model.put("template", "templates/main.vtl");
            model.put("articles", articles);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/articles/dashboard", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Article> articles = DBHelper.getAll(Article.class);

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            model.put("template", "templates/articles/index.vtl");
            model.put("articles", articles);

            return new ModelAndView(model, "templates/adminLayout.vtl");
        }, new VelocityTemplateEngine());

        get("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);

            model.put("template", "templates/articles/view.vtl");
            model.put("article", article);
            return new ModelAndView(model, "templates/adminLayout.vtl");

        }, new VelocityTemplateEngine());
    }
}
