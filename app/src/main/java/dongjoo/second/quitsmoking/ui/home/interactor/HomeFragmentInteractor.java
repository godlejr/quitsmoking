package dongjoo.second.quitsmoking.ui.home.interactor;


import dongjoo.second.quitsmoking.ui.base.interactor.BaseInteractor;
import dongjoo.second.quitsmoking.ui.home.presenter.HomeFragmentPresenter;

public interface HomeFragmentInteractor<V extends HomeFragmentPresenter> extends BaseInteractor<V> {

    boolean isHomeFragmentPause();

    void setHomeFragmentPause(boolean homeFragmentPause);
}
