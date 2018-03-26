package db;

import models.Article;
import models.Editor;
import models.HRManager;
import models.Journalist;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Editor.class);
        DBHelper.deleteAll(HRManager.class);

        Journalist journalist1 = new Journalist("Suzy", "Smith");
        DBHelper.saveOrUpdate(journalist1);
        Journalist journalist2 = new Journalist("Cliff", "Hanger");
        DBHelper.saveOrUpdate(journalist2);
        Journalist journalist3 = new Journalist("Matilda", "Storm");
        DBHelper.saveOrUpdate(journalist3);

        Editor editor1 = new Editor("Max", "Powers");
        DBHelper.saveOrUpdate(editor1);

        HRManager hrManager1 = new HRManager("Sam", "Brown");
        DBHelper.saveOrUpdate(hrManager1);

        Article article1 = new Article("Jurassic Escape", journalist1);
        DBHelper.saveOrUpdate(article1);
        Article article2 = new Article("BumTree Scandal", journalist2);
        DBHelper.saveOrUpdate(article2);
        Article article3 = new Article("Motorcycle Mayhem", journalist3);
        DBHelper.saveOrUpdate(article3);
    }
}
