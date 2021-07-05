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
        String tempFileName;
        File tempFilePath;
        String oriFileMD5,secFileMD5;
        fileUtil.delDictionary(parentFile);


        for (int i = 0; i < listFile.size(); i++) {
            tempFileName = listFile.get(i).getName();
            tempFilePath = listFile.get(i).getAbsoluteFile();
            /**
             * 如果包含，对比MD5，如果不包含，放过，最后输出下就可以
             */
            if(selMap.containsKey(tempFileName)){
                oriFileMD5 = MD5Util.getFileMD5StringBase16(selMap.get(tempFileName));
                secFileMD5 = MD5Util.getFileMD5StringBase16(tempFilePath);
                if (oriFileMD5.equals(secFileMD5)) {
                    fileUtil.deleteFileStr(tempFilePath);
                    System.out.println("fileName:\t" + tempFileName + "\n 原路径:" +selMap.get(tempFileName) + "\t 新路径：" + tempFilePath + "\n old MD5:" + oriFileMD5 + "\t new MD5:" + secFileMD5);
                }
            }else {
                selMap.put(tempFileName, tempFilePath);
            }

        }


//        System.out.println(listFile.get(1).getName());
//        System.out.println(listFile.get(1).getAbsoluteFile());


    }

}
