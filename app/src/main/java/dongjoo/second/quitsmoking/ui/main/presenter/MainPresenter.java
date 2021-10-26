package dongjoo.second.quitsmoking.ui.main.presenter;

import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;
import dongjoo.second.quitsmoking.ui.main.view.MainView;

public interface MainPresenter<V extends MainView> extends BasePresenter<V> {
    void onResume();

    void onBackPressed();

    void onActivityResultForAppDestroyOk();
    // void onRequestPermissionsResultForSMSReceive(int[] grantResults);

  //  void onClickLogout();

}
