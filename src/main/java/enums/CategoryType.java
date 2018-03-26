package enums;

public enum CategoryType {
    NONE("none"),
    NEWS("news"),
    SPORT("sport"),
    ENTERTAINMENT("entertainment");

    private String categoryType;

    CategoryType(String categoryType){
        this.categoryType = categoryType;
    }

    public String getCategoryType(){
        return categoryType;
    }
    }
