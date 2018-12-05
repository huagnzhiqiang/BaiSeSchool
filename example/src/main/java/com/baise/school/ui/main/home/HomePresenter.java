package com.baise.school.ui.main.home;


import com.baise.baselibs.mvp.BasePresenter;

/**
 * @author 小强
 * @time  2018/6/12 22:57
 * @desc
 */
public class HomePresenter extends BasePresenter<HomeContract.Model,HomeContract.View> {
    @Override
    protected HomeContract.Model createModel() {
        return new HomeModel();
    }


    public void requestData(){
//        getModel().getGankData()
//                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
//                .subscribe(new BaseObserver<List<TestNews>>(getView()) {
//                    @Override
//                    public void onSuccess(BaseHttpResult<List<TestNews>> result) {
//                        if (result != null) {
//                            getView().showData(result.getData());
//                            Logger.d("onSuccess--->:" + result);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(String errMsg, boolean isNetError) {
//                        getView().showError(errMsg);
//                        Logger.d("onSuccess--->:" + errMsg);
//                        Logger.d("onSuccess--->:" + isNetError);
//
//                    }
//                });
    }
}
