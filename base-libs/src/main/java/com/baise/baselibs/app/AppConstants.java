package com.baise.baselibs.app;

import android.os.Environment;

import java.io.File;

/**
 * @author 小强
 * @time 2018/6/10 16:18
 * @desc app 常量
 */
public class AppConstants {

    /**
     * Path
     */
    public static final String PATH_DATA = BaseApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    static final String BUGLY_ID = "16e54f8921";

    public final static String XF_SET_VOICE_RECORD="VOICE_RECORD";//录音语言

    public static final String FILE_VOICE_CACHE = Environment.getExternalStorageDirectory() + "/baiSe/voice/";

    public static String XF_VOICE_APPID = "5c1747c1";//讯飞语音appid
}
