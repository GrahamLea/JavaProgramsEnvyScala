package Example_05_PimpMyLibrary;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import static Example_05_PimpMyLibrary.MyFileExtensions.excluding;
import static Example_05_PimpMyLibrary.MyFileExtensions.find;

    class MyFileExtensions {
        public static List<File> find(File directory, FileFilter filter) {
            ArrayList<File> files = new ArrayList<File>();
            File[] children = directory.listFiles();
            if (children != null) {
                for (File file : children) {
                    if (filter.accept(file)) {
                        files.add(file);
                    }
                    if (file.isDirectory()) {
                        files.addAll(find(file, filter));
                    }
                }
            }
            return files;
        }

        public static List<File> excluding(String namePart, List<File> files) {
            ArrayList<File> result = new ArrayList<File>();
            for (File file : files) {
                if (!file.getAbsolutePath().contains(namePart))
                    result.add(file);
            }
            return result;
        }
    }

public class AugmentingClassesInJavaWithStaticImports {

    private static final FileFilter JPG_FILE_FILTER = new FileFilter() {
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".jpg");
        }
    };

    public static void main(String[] args) {
        File home = new File(System.getProperty("user.home"));
        for (File file : excluding("Temp", find(home, JPG_FILE_FILTER))) {

            System.out.println(file);
        }
    }
}
