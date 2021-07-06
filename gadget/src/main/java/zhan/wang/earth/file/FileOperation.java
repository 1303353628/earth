package zhan.wang.earth.file;


import zhan.wang.earth.encode.MD5Util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileOperation {

    public static void main(String[] args) {
        String parentFile = "/Users/wangzhiyuan/Desktop/book";
        File sourthFile = new File(parentFile);
        FileUtil fileUtil = new FileUtil();
        List<File> listFile = fileUtil.readFiles(sourthFile);
        Map<String, File> selMap = new HashMap<String,File>();
        String tempFileMD5String;
        File tempFilePath;
        fileUtil.delDictionary(parentFile);


        for (int i = 0; i < listFile.size(); i++) {
            tempFileMD5String = MD5Util.getFileMD5StringBase16(listFile.get(i));
            tempFilePath = listFile.get(i);
            /**
             * 如果包含，对比MD5，如果不包含，放过，最后输出下就可以
             */
            if(selMap.containsKey(tempFileMD5String)){
                System.out.println("源文件地址：" + selMap.get(tempFileMD5String) + "\t " +
                        "重复文件地址：" + tempFilePath.getAbsoluteFile());
                fileUtil.deleteFileStr(tempFilePath);
            }else {
                selMap.put(tempFileMD5String, tempFilePath);
            }
        }
    }

}
