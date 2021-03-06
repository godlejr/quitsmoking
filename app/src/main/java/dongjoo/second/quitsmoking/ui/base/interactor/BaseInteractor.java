package dongjoo.second.quitsmoking.ui.base.interactor;


import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;

/**
 * BaseInteractor
 *
 * @author 김동주
 * @since 2021.10.07
 */

public interface BaseInteractor<V extends BasePresenter> {
    public void onAttach(V basePresenter);

    public void init();

}
