package dynamicLocator;

import commons.BasePage;

public class StringFormat{
    public static void main(String[] args) {
        String var1 = "//a[text()='%s']",
                var2 = "//a[text()='%s']/button[text()='%s']",
                var3 = "//a[text()='%s']/button[text()='%s']/a[text()='%s']";
        String addText1 = "Log in",
                addText2 = "Log out",
                addText3 = "My Account";

        printText(var1, addText1);
        printText(var2, addText1, addText2);
        printText(var3, addText1, addText2, addText3);
    }

    public static void printText(String var, String addText) {
        System.out.println("The emelement is: " + String.format(var, addText));
    }

    public static void printText(String var, String addText1, String addText2) {
        System.out.println("The emelement is: " + String.format(var, addText1, addText2));
    }

    public static void printText(String var, String addText1, String addText2, String addText3) {
        System.out.println("The emelement is: " + String.format(var, addText1, addText2, addText3));
    }
}
