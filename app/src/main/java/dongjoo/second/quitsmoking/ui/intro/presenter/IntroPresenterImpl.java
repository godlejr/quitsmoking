package dongjoo.second.quitsmoking.ui.intro.presenter;


import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenterImpl;
import dongjoo.second.quitsmoking.ui.intro.view.IntroView;

public class IntroPresenterImpl<V extends IntroView> extends BasePresenterImpl<V> implements IntroPresenter<V> {
    public IntroPresenterImpl() {
    }

    @Override
    public void init() {
        getBaseView().setFadeInAnimationListener();
        getBaseView().setSplashFadeInAnimation();
        getBaseView().showSplash();
    }

    @Override
    public void onDestroySplash() {
        getBaseView().navigateToMainActivity();

    }

    @Override
    public void onAnimationEnd() {
        getBaseView().setSplashFadeOutAnimation();
    }
}
