package db;

import enums.CategoryType;
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

        Editor editor1 = new Editor("Max", "Powers");
        DBHelper.saveOrUpdate(editor1);

        HRManager hrManager1 = new HRManager("Sam", "Brown");
        DBHelper.saveOrUpdate(hrManager1);

        Journalist journalist1 = new Journalist("Suzy", "Smith");
        DBHelper.saveOrUpdate(journalist1);
        Journalist journalist2 = new Journalist("Cliff", "Hanger");
        DBHelper.saveOrUpdate(journalist2);
        Journalist journalist3 = new Journalist("Matilda", "Storm");
        DBHelper.saveOrUpdate(journalist3);
        Journalist journalist4 = new Journalist("John", "McCollum");
        DBHelper.saveOrUpdate(journalist4);
        Journalist journalist5 = new Journalist("Louise", "Reid");
        DBHelper.saveOrUpdate(journalist5);


        // DRAFT ARTICLES:
        Article article1 = new Article("Jurassic Escape", journalist1);
        article1.setImage("jurassic.jpg");
        DBHelper.saveOrUpdate(article1);

        Article article2 = new Article("BumTree Scandal", journalist2);
        article2.setImage("rebrand.jpg");
        DBHelper.saveOrUpdate(article2);

        Article article3 = new Article("Motorcycle Mayhem", journalist3);
        article3.setImage("motorcycle.jpg");
        DBHelper.saveOrUpdate(article3);


        // REVIEW ARTICLES:
        Article reviewArticle1 = new Article("New Codeclan Student", journalist4);
        reviewArticle1.setLede("Sophia robot learns to code: will AI robots get equal employment opportunities?");
        reviewArticle1.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        reviewArticle1.setImage("sophiarobot.jpg");
        reviewArticle1.setCategory(CategoryType.NEWS);
        reviewArticle1.setPublishedDate((GregorianCalendar) currentTime);
        reviewArticle1.setStatus(StatusType.REVIEW);
        DBHelper.saveOrUpdate(reviewArticle1);

        Article reviewArticle2 = new Article("FreeStyle Gold Medal Winner", journalist5);
        reviewArticle2.setLede("US athlete wins gold medal in the 2018 Olympic Games for 100m freestyle");
        reviewArticle2.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        reviewArticle2.setImage("swimming.jpg");
        reviewArticle2.setCategory(CategoryType.SPORT);
        reviewArticle2.setPublishedDate((GregorianCalendar) currentTime);
        reviewArticle2.setStatus(StatusType.REVIEW);
        DBHelper.saveOrUpdate(reviewArticle2);



        // PUBLISH ARTICLES:
        Article article4 = new Article("Five-a-side Chaos", journalist1);
        article4.setLede("Trouble in the city when local football team kick ball into passers-by");
        article4.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                        "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        article4.setImage("fives.jpg");
        article4.setCategory(CategoryType.SPORT);
        article4.setPublishedDate((GregorianCalendar) currentTime);
        article4.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article4);

        Article article5 = new Article("Glasgow Pub Brawl", journalist2);
        article5.setLede("Three dead and five critically injured when fight breaks out in the Dog and Hound");
        article5.setCategory(CategoryType.NEWS);
        article5.setStory("<p>Bacon ipsum dolor amet strip steak flank jowl frankfurter sunt. Ham hock spare ribs non pork chop alcatra. Dolor shoulder doner, meatball strip steak enim veniam cillum anim aute eu exercitation ham hock deserunt. In nostrud ground round boudin fugiat rump irure leberkas mollit sunt aute tenderloin tail lorem cillum. Shankle chuck incididunt biltong voluptate, shoulder officia aliquip ullamco sed spare ribs ut. Venison lorem jerky, flank cupim et short ribs anim minim culpa hamburger kielbasa.</p>" +
                "<p>Short ribs voluptate anim turkey, aliqua in laborum minim burgdoggen sint officia spare ribs jowl. Fugiat voluptate ham hock, t-bone id mollit pariatur. Minim et pig pork chop pariatur veniam commodo bacon, drumstick velit est tempor venison capicola hamburger. Biltong andouille swine voluptate ex, consequat in alcatra sint brisket jowl short ribs. Cow irure tongue corned beef jowl eu porchetta buffalo. Adipisicing qui swine pork belly pork lorem. Consectetur t-bone magna lorem tri-tip in.</p>" +
                "<p>Aliqua consequat qui swine short loin, andouille incididunt officia shank. Meatball tail laboris doner excepteur, exercitation leberkas mollit veniam meatloaf ipsum adipisicing. Eu hamburger t-bone, incididunt fugiat buffalo landjaeger. Velit beef boudin, doner chicken commodo proident elit flank incididunt salami.</p>");
        article5.setImage("pub-brawl.jpg");
        article5.setPublishedDate((GregorianCalendar) currentTime);
        article5.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article5);

        Article article6 = new Article("Russian Spies Evicted", journalist3);
        article6.setLede("Nerve gas outbreak sends politicians into red alert");
        article6.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p" +
                "<p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        article6.setImage("russian-spy.jpg");
        article6.setPublishedDate((GregorianCalendar) currentTime);
        article6.setCategory(CategoryType.NEWS);
        article6.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article6);

        Article article7 = new Article("4D Cinema Opens in Glasgow", journalist4);
        article7.setLede("The next generation of entertainment has arrived! Tickets to all shows are sold out for the next six months");
        article7.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p" +
                "<p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        article7.setImage("smartindustry.jpg");
        article7.setPublishedDate((GregorianCalendar) currentTime);
        article7.setCategory(CategoryType.ENTERTAINMENT);
        article7.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article7);

        Article article8 = new Article("Trump Dollar", journalist5);
        article8.setLede("The Dollar continues to decline against the Pound while Trump remains President");
        article8.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p" +
                "<p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        article8.setImage("dollar.jpg");
        article8.setPublishedDate((GregorianCalendar) currentTime);
        article8.setCategory(CategoryType.NEWS);
        article8.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article8);
    }
}
