package com.kw.kw.util;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileHandler {
    static public String makeStoredPath(String fileExt){
        Long nano = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS.sss");
        String currentDate = simpleDateFormat.format(nano);
        String absolutePath = new File("").getAbsolutePath() + "\\" + "images\\";
        String storedPath = absolutePath + currentDate + fileExt;
        return storedPath;
    }
}
