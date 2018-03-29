package controllers;

import db.DBHelper;
import enums.CategoryType;
import enums.StatusType;
import models.Article;
import models.Employee;
import models.Editor;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import javax.jws.WebParam;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticlesController {
    public ArticlesController(){
        this.setupEndpoints();
    }

    private void setupEndpoints(){

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Article> articles = DBHelper.getAllOrderByProperty(Article.class, "publishedDate");

            model.put("template", "templates/main.vtl");
            model.put("articles", articles);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String category = req.queryParams("category");

            // First argument must be null or a string value of the CategoryType ENUM:
//            List<Article> articles = DBHelper.getAllArticlesFilterByCategoryOrderByProperty(null, "publishedDate");
            List<Article> articles = DBHelper.getAllArticlesFilterByCategoryOrderByProperty(category, "publishedDate");

            model.put("template", "templates/main.vtl");
            model.put("articles", articles);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/articles/dashboard", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            List<Article> articles = DBHelper.getAllArticles(loggedInEmployee);

            model.put("user", loggedInUser);
            model.put("loggedInEmployee", loggedInEmployee);
            model.put("loggedInEmployeeType", loggedInEmployeeType);

            model.put("template", "templates/articles/index.vtl");
            model.put("articles", articles);

            return new ModelAndView(model, "templates/adminLayout.vtl");
        }, new VelocityTemplateEngine());

        get("/articles/create", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<CategoryType> articleCategories = DBHelper.getAllArticleCategories();

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            model.put("user", loggedInUser);
            model.put("loggedInEmployee", loggedInEmployee);
            model.put("loggedInEmployeeType", loggedInEmployeeType);
            model.put("articleCategories", articleCategories);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/adminLayout.vtl");
        }, new VelocityTemplateEngine());

        post ("/articles/create", (req, res) -> {
            String headline = req.queryParams("headline");
            String lede = req.queryParams("lede");
            String story = req.queryParams("story");
            String image = req.queryParams("image");
            String strCategory = req.queryParams("category");
            CategoryType enumCategory = CategoryType.valueOf(strCategory);

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            Article article = new Article(headline, (Journalist) loggedInEmployee);
            article.setLede(lede);
            article.setStory(story);
            article.setImage(image);
            article.setCategory(enumCategory);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;

        }, new VelocityTemplateEngine());

        get("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);

            Map<String, Object> model = new HashMap<>();

            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            model.put("user", loggedInUser);
            model.put("loggedInEmployee", loggedInEmployee);
            model.put("loggedInEmployeeType", loggedInEmployeeType);

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

        post ("/articles/:id/review", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article article= DBHelper.find(id, Article.class);
            article.setStatus(StatusType.REVIEW);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;
        }, new VelocityTemplateEngine());

        post ("/articles/:id/reject", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article article= DBHelper.find(id, Article.class);
            article.setStatus(StatusType.DRAFT);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;
        }, new VelocityTemplateEngine());

        post ("/articles/:id/publish", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article article= DBHelper.find(id, Article.class);
            article.setStatus(StatusType.PUBLISH);
            Calendar todayDate = GregorianCalendar.getInstance();
            article.setPublishedDate((GregorianCalendar) todayDate);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;
        }, new VelocityTemplateEngine());

        get("/articles/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);
            List<CategoryType> articleCategories = DBHelper.getAllArticleCategories();

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            Employee loggedInEmployee = DBHelper.findEmployee(loggedInUser);
            String loggedInEmployeeType = DBHelper.findEmployeeType(loggedInUser);

            model.put("user", loggedInUser);
            model.put("loggedInEmployee", loggedInEmployee);
            model.put("loggedInEmployeeType", loggedInEmployeeType);
            model.put("articleCategories", articleCategories);
            model.put("template", "templates/articles/edit.vtl");
            model.put("article", article);

            return new ModelAndView(model, "templates/adminLayout.vtl");
        }, new VelocityTemplateEngine());

        post ("/articles/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);

            String headline = req.queryParams("headline");
            String lede = req.queryParams("lede");
            String story = req.queryParams("story");
            String image = req.queryParams("image");
            String strCategory = req.queryParams("category");
            CategoryType enumCategory = CategoryType.valueOf(strCategory);

            article.setHeadLine(headline);
            article.setLede(lede);
            article.setStory(story);
            article.setImage(image);
            article.setCategory(enumCategory);
            DBHelper.saveOrUpdate(article);
            res.redirect("/articles/dashboard");
            return null;

        }, new VelocityTemplateEngine());

        ///// FRONTENT --
        get("/articles/view/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Article article = DBHelper.find(intId, Article.class);

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/articles/fullView.vtl");
            model.put("article", article);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());
    }
}
