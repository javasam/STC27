package lesson_6.Home_work_6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderList {
    public List showFolderList() {
        List list = new ArrayList();
        File folder = new File("./");
        for (File file : folder.listFiles()) {
            list.add(file.getName());
        }
        return list;
    }
}
