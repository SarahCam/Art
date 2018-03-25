package db;

import models.Editor;
import models.Journalist;

public class Seeds {

    public static void seedData() {

//        DBHelper.deleteAll(Article.class);
//        DBHelper.deleteAll(Journalist.class);
//        DBHelper.deleteAll(Editor.class);

        Journalist journalist1 = new Journalist("Suzy", "Smith");
//        DBHelper.save(journalist1);
        Journalist journalist2 = new Journalist("Cliff", "Hanger");
//        DBHelper.save(journalist2);
        Journalist journalist3 = new Journalist("Matilda", "Storm");
//        DBHelper.save(journalist3);

        Editor editor1 = new Editor("Max", "Powers");
//        DBHelper.save(editor1);

//        HRManager hrManager1 = new HRManager("Sam", "Brown");
//        DBHelper.save(hrManager1);

    }
}
