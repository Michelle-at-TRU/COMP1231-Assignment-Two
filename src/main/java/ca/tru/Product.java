package ca.tru;

import java.nio.file.AccessDeniedException;

public class Product implements Category, PasswordLockable, Comparable<Product> {

    // I don't like this being mutable, but the assignment specifically wants it to
    // be
    private String productCode;

    // description is used more like product name, I don't want to change the name
    // since the assignment gave it to me
    private String description;
    private int category;
    private double price;
    private String password;
    private boolean productIsLocked = false;

    // TODO setters should only work if unlocked
    // TODO compareTo should be used to determine lowest price

    Product(String productCode) {
        this.productCode = productCode;
        this.description = "Unknown";
        this.category = 0;
        this.price = 0.00;
        // I like having an incomplete constructor, but this seems to be the test
        // exhibit's default state
    }

    Product(String productCode, String description, int category, double price, String password) {
        this.productCode = productCode;
        this.description = description;
        this.category = category;
        this.price = price;
        this.password = password;
        lock(password);
    }

    public Product setProductCode(String productCode) {
        if (isLocked())
            throw new SecurityException(getExceptionMessage("Code"));
        this.productCode = productCode;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public Product setPrice(double price) {
        if (isLocked())
            throw new SecurityException(getExceptionMessage("Price"));
        this.price = price;
        return this;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PasswordLockable setPassword(String password) {
        if (isLocked())
            throw new SecurityException(getExceptionMessage("Password"));
        this.password = password;
        return this;
    }

    @Override
    public PasswordLockable lock(String password) {
        if (!this.password.equals(password))
            throw new SecurityException(
                    "Attempted to Lock with wrong password, and locking requires a password for some reason");
        this.productIsLocked = true;
        return this;
    }

    @Override
    public PasswordLockable unlock(String password) {
        if (!this.password.equals(password))
            throw new SecurityException("Attempted to Unlock with wrong password");
        this.productIsLocked = false;
        return this;
    }

    @Override
    public boolean isLocked() {
        return productIsLocked;
    }

    @Override
    public Category setCategory(int categoryID) {
        if (isLocked())
            throw new SecurityException(getExceptionMessage("Category"));
        this.category = categoryID;
        return this;
    }

    @Override
    public Category setCategory(String categoryName) {
        if (isLocked())
            throw new SecurityException(getExceptionMessage("Category"));
        categoryName = categoryName.toLowerCase();

        switch (categoryName) {
            case "unclassified":
                setCategory(UNCLASSIFIED);
                break;

            case "meat":
                setCategory(MEAT);
                break;

            case "vegetable":
                setCategory(VEGETABLE);
                break;

            case "dairy":
                setCategory(DAIRY);
                break;

            case "fruit":
                setCategory(FRUIT);
                break;

            default:
                throw new IllegalArgumentException("Unknown Category:" + categoryName);
        }

        return this;
    }

    @Override
    public int getCategory() {
        return category;
    }

    @Override
    public String getCategoryName() {
        switch (category) {
            case UNCLASSIFIED:
                return "Unclassified";

            case DAIRY:
                return "Dairy";

            case MEAT:
                return "Meat";

            case VEGETABLE:
                return "Vegetable";

            case FRUIT:
                return "Fruit";

            default:
                throw new IllegalStateException("Unknown Catergory Code:" + category);
        }
    }

    public String toString() {
        return "Product Code:" + productCode + "\t Description:" + description + "\t Price:$"
                + String.format("%.2f", price) + "\t Category:" + getCategoryName();
    }

    private String getExceptionMessage(String variableAttemptedToChange) {
        return "Cannot change Product" + variableAttemptedToChange
                + " while product is locked. Please unlock product to try again.";
    }

}
