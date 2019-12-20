package co.zephyrl;

public class Cat {
    private String cname;
    private int cage;
    private String ccolor;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCcolor() {
        return ccolor;
    }

    public void setCcolor(String ccolor) {
        this.ccolor = ccolor;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "cname='" + cname + '\'' +
                ", cage=" + cage +
                ", ccolor='" + ccolor + '\'' +
                '}';
    }
}
