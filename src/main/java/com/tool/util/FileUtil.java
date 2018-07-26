package com.tool.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by admin on 2018/7/25.
 */
public class FileUtil {

    public static InputStream getFileSource(String filePath){
        File file = new File(filePath);
        if(file.isFile()){
            try {
                InputStream in = new FileInputStream(file);
                return in;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
