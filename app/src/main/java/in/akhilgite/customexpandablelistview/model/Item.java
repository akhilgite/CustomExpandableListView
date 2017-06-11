package in.akhilgite.customexpandablelistview.model;

import java.util.ArrayList;

/**
 * Created by akhil on 10/6/17.
 */

/**
 * Model class for holding Item row information
 */
public class Item {
    String category;
    boolean isExpanded;
    ArrayList<Row> arrayList;

    public Item(String category, boolean isExpanded, ArrayList<Row> arrayList) {
        this.category = category;
        this.isExpanded = isExpanded;
        this.arrayList = arrayList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public ArrayList<Row> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Row> arrayList) {
        this.arrayList = arrayList;
    }
}
