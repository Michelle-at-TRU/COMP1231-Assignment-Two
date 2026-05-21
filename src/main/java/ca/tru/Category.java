package ca.tru;

public interface Category {
    // I would probably make these enums instead if the assignment didn't specify
    // four integer constants
    int UNCLASSIFIED = 0;
    int FRUIT = 1;
    int VEGETABLE = 2;
    int MEAT = 3;
    int DAIRY = 4;

    Category setCategory(int categoryID);

    Category setCategory(String categoryName);

    int getCategory();

    String getCategoryName();
}
