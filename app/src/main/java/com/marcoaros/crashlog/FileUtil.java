package com.marcoaros.crashlog;

import android.os.Environment;

import java.io.File;

public class FileUtil {

    /**
     *  创建应用所需的文件夹
     * @return
     */
    public static boolean createAppFolder() {
        File folder = new File(getSDCardPath()+ File.separator + AppConstant.APP_DIR);
        if (!folder.exists() || !folder.isDirectory()) {
            return folder.mkdir();
        }else {
            return true;
        }
    }

    /**
     * 获取SD卡根路径
     * @return
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
