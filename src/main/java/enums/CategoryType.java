package enums;

public enum CategoryType {
    NONE("No Category"),
    LANDSCAPE("Landscape"),
    SEASCAPE("Seascape"),
    STILL_LIFE("Still Life");

    private String categoryName;

    CategoryType(String categoryName){
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }
}
