package ca.tru;

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

    public Product setProductCode(String code) {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public String getProductCode() {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public Product setPrice(double price) {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    @Override
    public int compareTo(Product arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public PasswordLockable setPassword(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPassword'");
    }

    @Override
    public PasswordLockable lock(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lock'");
    }

    @Override
    public PasswordLockable unlock(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unlock'");
    }

    @Override
    public boolean isLocked() {
        return productIsLocked;
    }

    @Override
    public Category setCategory(int categoryID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCategory'");
    }

    @Override
    public Category setCategory(String categoryName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCategory'");
    }

    @Override
    public int getCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategory'");
    }

    @Override
    public String getCategoryName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryName'");
    }

    public String toString() {
        return "Product Code:" + productCode + "\t Description:" + description + "\t Price:$"
                + String.format("%.2f", price) + "\t Category:" + getCategoryName();
    }

}
