package dongjoo.second.quitsmoking.ui.home.interactor;


import dongjoo.second.quitsmoking.ui.base.interactor.BaseInteractorImpl;
import dongjoo.second.quitsmoking.ui.home.presenter.HomeFragmentPresenter;

public class HomeFragmentInteractorImpl<V extends HomeFragmentPresenter> extends BaseInteractorImpl<V> implements HomeFragmentInteractor<V>{

    private boolean isHomeFragmentPause = false;

    public HomeFragmentInteractorImpl() {
    }

    @Override
    public void init() {

    }
    @Override
    public boolean isHomeFragmentPause() {
        return isHomeFragmentPause;
    }

    @Override
    public void setHomeFragmentPause(boolean homeFragmentPause) {
        isHomeFragmentPause = homeFragmentPause;
    }
}
