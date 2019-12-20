package co.zephyrl;

public class Cat {
    private String cname;
    private String color;

    @Override
    public String toString() {
        String ssex = "female";
        if (sex) {
            ssex = "male";
        }
        return "Cat{" +
                "cname='" + cname + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", sex='" + ssex + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    private int age;
    private boolean sex;

    public String getCname() {
        return cname;
    }

    public String getColor() {
        return color;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
