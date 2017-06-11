package in.akhilgite.customexpandablelistview.model;

/**
 * Created by akhil on 10/6/17.
 */

/**
 * Model class for row
 */
public class Row {
    private String header;
    private String deatils;
    private String time;
    private int resId;

    public Row(String header, String deatils, String time, int resId) {
        this.header = header;
        this.deatils = deatils;
        this.time = time;
        this.resId = resId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDeatils() {
        return deatils;
    }

    public void setDeatils(String deatils) {
        this.deatils = deatils;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
