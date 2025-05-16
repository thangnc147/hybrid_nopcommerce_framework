package javaBasic;

import javaOOP.Animals;

public class Topic_01_Keyword {

    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    long lnumber = 10000;
    int inumber = 1000;
    double dNumber = 10.10;
    float fnumber = 1.22F;
    boolean aStatus = true;

    // No need to return data type (void)
    void clickButtonA() {
    }

    // Must be a data (of type)
    String returnButtonName() {
        return "";
    }

    // Default (no annotation) can only use in same package
    String fullName = "Thang";

    // Can be use by any other class: public
    public String country = "Viet Nam";

    // Can use in this class and its extend: protected
    protected String city = "HCM";

    // Can only use in this class: private
    private String district = "Tan Binh";

    // Final: no override new value
    public static final String PI = "3.141529";

}
