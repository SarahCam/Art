package db;

import enums.StatusType;
import models.Article;
import models.Editor;
import models.HRManager;
import models.Journalist;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Editor.class);
        DBHelper.deleteAll(HRManager.class);

        Calendar currentTime = GregorianCalendar.getInstance();

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
        article1.setImage("jurassic.jpg");
        DBHelper.saveOrUpdate(article1);
        Article article2 = new Article("BumTree Scandal", journalist2);
        DBHelper.saveOrUpdate(article2);
        Article article3 = new Article("Motorcycle Mayhem", journalist3);
        DBHelper.saveOrUpdate(article3);
        Article article4 = new Article("Five-Aside Chaos", journalist1);
        article4.setLede("Trouble in the city when local football team kick ball into passers-by");
        article4.setStory("Blah blah blah");
        article4.setImage("fives.jpg");
        article4.setPublishedDate((GregorianCalendar) currentTime);
        article4.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article4);
        Article article5 = new Article("Glasgow Pub Brawl", journalist2);
        article5.setLede("Three dead and five critically injured when fight breaks out in the Dog and Hound");
        article5.setStory("Blah blah blah");
        article5.setImage("image.jpg");
        article5.setPublishedDate((GregorianCalendar) currentTime);
        article5.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article5);
        Article article6 = new Article("Russian Spies Evicted", journalist3);
        article6.setLede("Nerve gas outbreak sends politicians into red alert");
        article6.setStory("Blah blah blah");
        article6.setImage("image.jpg");
        article6.setPublishedDate((GregorianCalendar) currentTime);
        article6.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article6);
    }
}
