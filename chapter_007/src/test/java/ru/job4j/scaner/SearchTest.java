package ru.job4j.scaner;

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenScanFilesThenExist() {
        List<String> listExtension = List.of("txt", "exe");
        String parent = System.getProperty("java.io.tmpdir") + "Test/";
        File[] directory = new File[]{
                new File(parent + "Dir1/"),
                new File(parent + "Dir2/Folder1/Folder2/"),
                new File(parent + "Dir3/Folder1/Folder2/"),
                new File(parent + "Dir4/Folder1/"),
                new File(parent + "Dir5/Folder1/Folder2/"),
                new File(parent + "Dir6/Folder1/Folder2/Folder3/")};
        File[] expected = new File[]{
                new File(parent + "Dir1/file.txt"),
                new File(parent + "Dir2/file1234.exe"),
                new File(parent + "Dir2/Folder1/Folder2/file.exe"),
                new File(parent + "Dir2/Folder1/file123.exe"),
                new File(parent + "Dir3/Folder1/Folder2/file.txt"),
                new File(parent + "Dir4/Folder1/fileOne.exe"),
                new File(parent + "Dir4/Folder1/fileTwo.exe"),
                new File(parent + "Dir5/Folder1/Folder2/file.txt"),
                new File(parent + "Dir6/Folder1/Folder2/Folder3/file.exe")};

        Arrays.stream(directory).filter(folder -> !folder.exists()).forEach(folder -> folder.mkdirs());
        Arrays.stream(expected).filter(file -> !file.exists()).forEach(file -> {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        assertThat(Search.files(parent, listExtension), containsInAnyOrder(expected));
    }
}