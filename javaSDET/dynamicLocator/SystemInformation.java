package dynamicLocator;

import java.io.File;
import java.lang.ref.SoftReference;

public class SystemInformation {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println("-------------------");
        System.out.println("OS Name: " + osName);

        String projectPath = System.getProperty("user.dir");
        System.out.println("Path on Device: " + projectPath);

        String image01Path = projectPath + "\\" + "uploadFiles" + "\\" + "Image01.png";
        System.out.println("File Path: " + image01Path);

        String image01Path_2 = projectPath + File.separator + "uploadFiles" + File.separator + "Image01.png";
        System.out.println("File Path: " + image01Path_2);
        System.out.println("-------------------");


    }
}
