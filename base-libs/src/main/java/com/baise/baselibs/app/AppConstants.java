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


    public static final String FILE_VOICE_CACHE = Environment.getExternalStorageDirectory() + "/baiSe/voice/";

    public static String XF_VOICE_APPID = "5c1747c1";//讯飞语音appid


    public final static String XF_SET_VOICE_RECORD = "VOICE_RECORD";//录音语言

    public final static String XF_SET_VOICE_READ = "XF_SET_VOICE_READ";//朗读语言

    public final static String READING = "reading";//朗读设置

    public final static String MANDARIN = "mandarin";//普通话

    public final static String CANTONESE = "cantonese";//粤语

    public final static String HENANESE = "henanese";//河南话

    public final static String EN_US = "en_us";//英语

    public final static String XIAO_MEI = "xiaomei";//女粤语

    public final static String XIAO_YU = "xiaoyu";//男普通话

    public final static String XIAO_YAN = "xiaoyan";//女普通话

    public final static String XIAO_LIN = "xiaolin";//女台湾话

    public final static String XIAO_RONG = "xiaorong";//女四川话

    public final static String XIAO_KUN = "xiaokun";//男河南话
}
