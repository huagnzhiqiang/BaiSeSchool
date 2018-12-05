package com.baise.school.ui.main.mine;

import com.baise.school.data.entity.LoginEntity;
import com.baise.school.data.entity.MineEntity;
import com.baise.school.data.repository.RetrofitUtils;
import com.baise.baselibs.mvp.BaseModel;
import com.baise.baselibs.net.BaseHttpResult;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author 小强
 * @time  2018/6/13 15:35
 * @desc
 */
public class MineModel extends BaseModel implements MineContract.Model {


    @Override
    public Observable<BaseHttpResult<MineEntity>> getMineData() {
        return RetrofitUtils.getHttpService().getMineData();
    }

    @Override
    public Observable<BaseHttpResult<LoginEntity>> getLoginData(Map<String,String> map) {
        return RetrofitUtils.getHttpService().getLoginData(map);
    }

}
