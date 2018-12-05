package com.baise.school.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.baise.baselibs.app.BaseApplication;
import com.baise.baselibs.utils.CommonUtils;

/**
 * @author 小强
 * @date 2018/7/10 16:20
 * @desc Application
 */
public class App extends BaseApplication {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Bugly
        initBugly();


    }


    private void initBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = CommonUtils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        //        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        //        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        //        CrashReport.initCrashReport(getApplicationContext(), MyConstants.BUGLY_ID, false, strategy);
    }



}
