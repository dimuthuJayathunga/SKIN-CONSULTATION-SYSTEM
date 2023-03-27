public class Person {
    private String name;
    private String surName;
    private String dob;
    private int mblNumber;

    public Person(String name, String surName, String dob, int mblNumber) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.mblNumber = mblNumber;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMblNumber() {
        return mblNumber;
    }

    public void setMblNumber(int mblNumber) {
        this.mblNumber = mblNumber;
    }


}
