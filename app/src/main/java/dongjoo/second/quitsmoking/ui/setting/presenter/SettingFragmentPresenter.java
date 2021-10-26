package dongjoo.second.quitsmoking.ui.setting.presenter;

import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;
import dongjoo.second.quitsmoking.ui.setting.view.SettingFragmentView;


public interface SettingFragmentPresenter<V extends SettingFragmentView> extends BasePresenter<V> {

    void onPause();

    void onResume();

    void onClickUserWrite();

    void onClickMail();

    void onClickPromotion();

    void onClickComment();
}
