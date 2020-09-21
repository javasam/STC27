package lesson_6.Home_work_6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FolderList {
    public List<String> getFolderList() {
        List<String> list = new ArrayList<>();
        File folder = new File("./");
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            list.add(file.getName());
        }
        return list;
    }
}
