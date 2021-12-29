package lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileFilterTest {
    private final File root = new File("src/main/java");

    @Test
    public void listAllFiles() {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
            assertEquals(21,files.length);
        }
    }

    @Test
    public void listDirectories_anonInnerClass() {
        File[] directories = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (directories != null) {
            assertEquals(13,directories.length);
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void listDirectories_expressionLambda() {
        File[] directories = root.listFiles(pathname -> pathname.isDirectory());
        if (directories != null) {
            assertEquals(13,directories.length);
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void listDirectories_blockLambda() {
        File[] directories = root.listFiles(pathname -> {
            return pathname.isDirectory();
        } );
        if (directories != null) {
            assertEquals(13,directories.length);
        }
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    public void listDirectories_usingVariable() {
        FileFilter filter = pathname -> pathname.isDirectory();     // this is better because the type is explicit

        File[] directories = root.listFiles(filter);

        if (directories != null) {
            assertEquals(13,directories.length);
        }

    }

    @Test
    public void listDirectories_methodReference() {

    }

    @Test
    public void javaSourceFiles() {

    }

    private String getErrorMessage() {
        return "";
    }

    @Test
    public void notNullArgument() {

    }

    @Test
    void iterateOverListOrMap() {

    }
}
