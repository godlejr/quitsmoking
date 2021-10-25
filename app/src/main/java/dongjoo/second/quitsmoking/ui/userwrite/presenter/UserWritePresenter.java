package dongjoo.second.quitsmoking.ui.userwrite.presenter;

import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;
import dongjoo.second.quitsmoking.ui.userwrite.view.UserWriteView;


public interface UserWritePresenter<V extends UserWriteView> extends BasePresenter<V> {
    void init();

    void onBackPressed();

    void onClickDate();

    void onClickTime();

    void onDateSet(int year, int monthOfYear, int dayOfMonth);

    void onTimeSet(int hourOfDay, int minute);

    void onFinishBtnClick();
}
