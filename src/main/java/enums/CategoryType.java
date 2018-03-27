package enums;

public enum CategoryType {
    NONE("No Category"),
    NEWS("News"),
    SPORT("Sport"),
    ENTERTAINMENT("Entertainment");

    private String categoryName;

    CategoryType(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }
    }
