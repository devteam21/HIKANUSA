package id.zapnut.project.HIKANUSA.Item;

import java.io.Serializable;

public class CategoryList implements Serializable {

    private String cid, category_name, total_books;

    public CategoryList(String cid, String category_name, String total_books) {
        this.cid = cid;
        this.category_name = category_name;
        this.total_books = total_books;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getTotal_books() {
        return total_books;
    }

    public void setTotal_books(String total_books) {
        this.total_books = total_books;
    }
}
