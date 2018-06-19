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

        Editor editor1 = new Editor("Allan", "Buchanan");
        DBHelper.saveOrUpdate(editor1);

        HRManager hrManager1 = new HRManager("Sarah", "Campbell");
        DBHelper.saveOrUpdate(hrManager1);

        Journalist journalist1 = new Journalist("Jane", "Campbell");
        DBHelper.saveOrUpdate(journalist1);

        // DRAFT ARTICLES:
        Article article1 = new Article("Autumn Leaves", journalist1);
        article1.setImage("AutumnLeaves.jpg");
        DBHelper.saveOrUpdate(article1);

        Article article2 = new Article("Barra Beach", journalist1);
        article2.setImage("BarraBeach.jpg");
        DBHelper.saveOrUpdate(article2);

        Article article3 = new Article("Fisherman's Hideaway", journalist1);
        article3.setImage("FishermansHideaway.jpg");
        DBHelper.saveOrUpdate(article3);


        // REVIEW ARTICLES:
        Article reviewArticle1 = new Article("Kirkton of Lethendy", journalist1);
        reviewArticle1.setLede("Acrylic on Canvas");
        reviewArticle1.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        reviewArticle1.setImage("KirktonOfLethendy.jpg");
        reviewArticle1.setCategory(CategoryType.LANDSCAPE);
        reviewArticle1.setPublishedDate((GregorianCalendar) currentTime);
        reviewArticle1.setStatus(StatusType.REVIEW);
        DBHelper.saveOrUpdate(reviewArticle1);

        Article reviewArticle2 = new Article("Pastures New", journalist1);
        reviewArticle2.setLede("Acrylic on Canvas");
        reviewArticle2.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        reviewArticle2.setImage("PasturesNew.jpg");
        reviewArticle2.setCategory(CategoryType.SEASCAPE);
        reviewArticle2.setPublishedDate((GregorianCalendar) currentTime);
        reviewArticle2.setStatus(StatusType.REVIEW);
        DBHelper.saveOrUpdate(reviewArticle2);



        // PUBLISH ARTICLES:
        Article article4 = new Article("Path to Nowhere", journalist1);
        article4.setLede("Acrylic on Canvas");
        article4.setStory("<p>Spicy jalapeno filet mignon rump buffalo deserunt qui fatback strip steak pork loin velit boudin. Rump velit boudin commodo swine leberkas. Veniam irure prosciutto brisket. Shankle lorem turducken, est hamburger shank mollit pariatur sint nisi. Pig qui nostrud cupidatat sirloin beef ut picanha sed corned beef anim. Dolore ham hock shank, landjaeger cupidatat tongue drumstick prosciutto. Mollit occaecat et, flank anim swine ground round ut non.</p>" +
                "                <p>Pancetta aute nulla, deserunt shank consequat drumstick nostrud. Proident biltong exercitation cillum tri-tip pork belly hamburger pastrami flank in t-bone. Pancetta filet mignon aliqua, voluptate flank pariatur sed short loin alcatra. Magna do t-bone ad short loin kielbasa. Ham velit andouille nostrud labore culpa irure.</p>" +
                        "<p>Tongue chuck sausage, eu tenderloin nisi jerky. Strip steak velit labore sunt pork chop ham hock short ribs tempor. Pork loin shoulder sed nostrud magna meatball. Turkey pork belly tenderloin, consequat jerky chicken tempor meatball. Tenderloin pork chop proident dolor. Rump bresaola doner, bacon ad strip steak alcatra chuck qui adipisicing kielbasa tempor drumstick tail cow. Culpa frankfurter est meatloaf.</p>");
        article4.setImage("PathToNowhere.jpg");
        article4.setCategory(CategoryType.LANDSCAPE);
        article4.setPublishedDate((GregorianCalendar) currentTime);
        article4.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article4);

        Article article5 = new Article("Poppy Field", journalist1);
        article5.setLede("Acrylic on Canvas");
        article5.setCategory(CategoryType.LANDSCAPE);
        article5.setStory("<p>Bacon ipsum dolor amet strip steak flank jowl frankfurter sunt. Ham hock spare ribs non pork chop alcatra. Dolor shoulder doner, meatball strip steak enim veniam cillum anim aute eu exercitation ham hock deserunt. In nostrud ground round boudin fugiat rump irure leberkas mollit sunt aute tenderloin tail lorem cillum. Shankle chuck incididunt biltong voluptate, shoulder officia aliquip ullamco sed spare ribs ut. Venison lorem jerky, flank cupim et short ribs anim minim culpa hamburger kielbasa.</p>" +
                "<p>Short ribs voluptate anim turkey, aliqua in laborum minim burgdoggen sint officia spare ribs jowl. Fugiat voluptate ham hock, t-bone id mollit pariatur. Minim et pig pork chop pariatur veniam commodo bacon, drumstick velit est tempor venison capicola hamburger. Biltong andouille swine voluptate ex, consequat in alcatra sint brisket jowl short ribs. Cow irure tongue corned beef jowl eu porchetta buffalo. Adipisicing qui swine pork belly pork lorem. Consectetur t-bone magna lorem tri-tip in.</p>" +
                "<p>Aliqua consequat qui swine short loin, andouille incididunt officia shank. Meatball tail laboris doner excepteur, exercitation leberkas mollit veniam meatloaf ipsum adipisicing. Eu hamburger t-bone, incididunt fugiat buffalo landjaeger. Velit beef boudin, doner chicken commodo proident elit flank incididunt salami.</p>");
        article5.setImage("PoppyField.jpg");
        article5.setPublishedDate((GregorianCalendar) currentTime);
        article5.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article5);

        Article article6 = new Article("Catch of the Day", journalist1);
        article6.setLede("Acrylic on Canvas");
        article6.setCategory(CategoryType.STILL_LIFE);
        article6.setStory("<p>Bacon ipsum dolor amet strip steak flank jowl frankfurter sunt. Ham hock spare ribs non pork chop alcatra. Dolor shoulder doner, meatball strip steak enim veniam cillum anim aute eu exercitation ham hock deserunt. In nostrud ground round boudin fugiat rump irure leberkas mollit sunt aute tenderloin tail lorem cillum. Shankle chuck incididunt biltong voluptate, shoulder officia aliquip ullamco sed spare ribs ut. Venison lorem jerky, flank cupim et short ribs anim minim culpa hamburger kielbasa.</p>" +
                "<p>Short ribs voluptate anim turkey, aliqua in laborum minim burgdoggen sint officia spare ribs jowl. Fugiat voluptate ham hock, t-bone id mollit pariatur. Minim et pig pork chop pariatur veniam commodo bacon, drumstick velit est tempor venison capicola hamburger. Biltong andouille swine voluptate ex, consequat in alcatra sint brisket jowl short ribs. Cow irure tongue corned beef jowl eu porchetta buffalo. Adipisicing qui swine pork belly pork lorem. Consectetur t-bone magna lorem tri-tip in.</p>" +
                "<p>Aliqua consequat qui swine short loin, andouille incididunt officia shank. Meatball tail laboris doner excepteur, exercitation leberkas mollit veniam meatloaf ipsum adipisicing. Eu hamburger t-bone, incididunt fugiat buffalo landjaeger. Velit beef boudin, doner chicken commodo proident elit flank incididunt salami.</p>");
        article6.setImage("CatchOfTheDay.jpg");
        article6.setPublishedDate((GregorianCalendar) currentTime);
        article6.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article6);

        Article article7 = new Article("Fruit Cocktail", journalist1);
        article7.setLede("Acrylic on Canvas");
        article7.setCategory(CategoryType.STILL_LIFE);
        article7.setStory("<p>Bacon ipsum dolor amet strip steak flank jowl frankfurter sunt. Ham hock spare ribs non pork chop alcatra. Dolor shoulder doner, meatball strip steak enim veniam cillum anim aute eu exercitation ham hock deserunt. In nostrud ground round boudin fugiat rump irure leberkas mollit sunt aute tenderloin tail lorem cillum. Shankle chuck incididunt biltong voluptate, shoulder officia aliquip ullamco sed spare ribs ut. Venison lorem jerky, flank cupim et short ribs anim minim culpa hamburger kielbasa.</p>" +
                "<p>Short ribs voluptate anim turkey, aliqua in laborum minim burgdoggen sint officia spare ribs jowl. Fugiat voluptate ham hock, t-bone id mollit pariatur. Minim et pig pork chop pariatur veniam commodo bacon, drumstick velit est tempor venison capicola hamburger. Biltong andouille swine voluptate ex, consequat in alcatra sint brisket jowl short ribs. Cow irure tongue corned beef jowl eu porchetta buffalo. Adipisicing qui swine pork belly pork lorem. Consectetur t-bone magna lorem tri-tip in.</p>" +
                "<p>Aliqua consequat qui swine short loin, andouille incididunt officia shank. Meatball tail laboris doner excepteur, exercitation leberkas mollit veniam meatloaf ipsum adipisicing. Eu hamburger t-bone, incididunt fugiat buffalo landjaeger. Velit beef boudin, doner chicken commodo proident elit flank incididunt salami.</p>");
        article7.setImage("FruitCocktail.jpg");
        article7.setPublishedDate((GregorianCalendar) currentTime);
        article7.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article7);

        Article article8 = new Article("Lobster Pot", journalist1);
        article8.setLede("Acrylic on Canvas");
        article8.setCategory(CategoryType.STILL_LIFE);
        article8.setStory("<p>Bacon ipsum dolor amet strip steak flank jowl frankfurter sunt. Ham hock spare ribs non pork chop alcatra. Dolor shoulder doner, meatball strip steak enim veniam cillum anim aute eu exercitation ham hock deserunt. In nostrud ground round boudin fugiat rump irure leberkas mollit sunt aute tenderloin tail lorem cillum. Shankle chuck incididunt biltong voluptate, shoulder officia aliquip ullamco sed spare ribs ut. Venison lorem jerky, flank cupim et short ribs anim minim culpa hamburger kielbasa.</p>" +
                "<p>Short ribs voluptate anim turkey, aliqua in laborum minim burgdoggen sint officia spare ribs jowl. Fugiat voluptate ham hock, t-bone id mollit pariatur. Minim et pig pork chop pariatur veniam commodo bacon, drumstick velit est tempor venison capicola hamburger. Biltong andouille swine voluptate ex, consequat in alcatra sint brisket jowl short ribs. Cow irure tongue corned beef jowl eu porchetta buffalo. Adipisicing qui swine pork belly pork lorem. Consectetur t-bone magna lorem tri-tip in.</p>" +
                "<p>Aliqua consequat qui swine short loin, andouille incididunt officia shank. Meatball tail laboris doner excepteur, exercitation leberkas mollit veniam meatloaf ipsum adipisicing. Eu hamburger t-bone, incididunt fugiat buffalo landjaeger. Velit beef boudin, doner chicken commodo proident elit flank incididunt salami.</p>");
        article8.setImage("LobsterPot.jpg");
        article8.setPublishedDate((GregorianCalendar) currentTime);
        article8.setStatus(StatusType.PUBLISH);
        DBHelper.saveOrUpdate(article8);

    }
}
