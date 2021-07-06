package zhan.wang.earth.file;

import org.junit.Test;

import java.io.File;

public class TestFileUtil {

    @Test
    public void testFileOperation() {
        File file = new File("/Users/wangzhiyuan/Desktop/book/temp");
        System.out.println(file.toString());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile().listFiles());
    }

}
