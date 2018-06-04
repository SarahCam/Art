package enums;

public enum CategoryType {
    NONE("No Category"),
    NEWS("Landscape"),
    SPORT("Seascape"),
    ENTERTAINMENT("Still Life");

    private String categoryName;

    CategoryType(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }
}
