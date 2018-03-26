package controllers;

import db.DBHelper;
import enums.CategoryType;
import models.Article;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.post;

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

            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);

            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            model.put("user", loggedInUser);
            model.put("loggedInEmployee", loggedInEmployee);
            model.put("loggedInEmployeeType", loggedInEmployeeType);

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

        post ("/articles/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article articleToDelete = DBHelper.find(id, Article.class);
            DBHelper.delete(articleToDelete);
            res.redirect("/articles/dashboard");
            return null;
        }, new VelocityTemplateEngine());

        get("/articles/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            List<CategoryType> categoryTypes = DBHelper.getAll(CategoryType.class);

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("categoryTypes", categoryTypes);
            model.put("template", "templates/articles/edit.vtl");
            model.put("article", article);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            String headline = req.queryParams("headline");
            String lede = req.queryParams("lede");
            String story = req.queryParams("story");
            String image = req.queryParams("image");

            article.setHeadLine(headline);
            article.setLede(lede);
            article.setStory(story);
            article.setImage(image);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;

        }, new VelocityTemplateEngine());
    }
}
