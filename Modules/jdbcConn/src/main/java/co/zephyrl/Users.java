package co.zephyrl;

import java.sql.Date;

public class Users {
    private int id;
    private int ages;
    private String uname;
    private int psd;
    private String cdata;
    private String msg;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", ages=" + ages +
                ", uname='" + uname + '\'' +
                ", psd=" + psd +
                ", cdata='" + cdata + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public String getUname(String uname) {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPsd(int psd) {
        return this.psd;
    }

    public void setPsd(int psd) {
        this.psd = psd;
    }

    public String getCdata(String cdata) {
        return this.cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }

    public String getMsg(String msg) {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
