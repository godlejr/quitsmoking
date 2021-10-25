package dongjoo.second.quitsmoking.ui.home.presenter;

import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;
import dongjoo.second.quitsmoking.ui.home.view.HomeFragmentView;


public interface HomeFragmentPresenter<V extends HomeFragmentView> extends BasePresenter<V> {

    void onPause();

    void onResume();

    void onClickUserWrite();
}
