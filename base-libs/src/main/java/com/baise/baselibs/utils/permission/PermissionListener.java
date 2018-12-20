package com.baise.baselibs.utils.permission;

import android.support.annotation.NonNull;

/**
 * @author 小强
 * @time 2018/6/22  14:03
 * @desc 申请系统权限管理回调
 */


public interface PermissionListener {

    /**
     * 通过授权
     * @param permission
     */
    void permissionGranted(@NonNull String[] permission);

    /**
     * 拒绝授权
     * @param permission
     */
    void permissionDenied(@NonNull String[] permission);
}
