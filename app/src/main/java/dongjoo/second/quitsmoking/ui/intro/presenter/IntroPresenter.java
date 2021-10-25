package dongjoo.second.quitsmoking.ui.intro.presenter;


import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;
import dongjoo.second.quitsmoking.ui.intro.view.IntroView;

/**
 * IntroView
 *
 * @author 김동주
 * @since 2021.10.07
 */
public interface IntroPresenter<V extends IntroView> extends BasePresenter<V> {
    void onDestroySplash();

    void onAnimationEnd();
}
