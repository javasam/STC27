package lesson_6.Home_work_6;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestClass {
    @Test
    public void whenCallMethodThenGetFolderList() {
        FolderList folderList = new FolderList();
        assertThat(false, is(folderList.getFolderList().isEmpty()));
    }

    @Test
    public void whenCallMethodThenStartMethod() {
        //HttpServer server = HttpServer.create(Mockito.mock(2));

    }

}
