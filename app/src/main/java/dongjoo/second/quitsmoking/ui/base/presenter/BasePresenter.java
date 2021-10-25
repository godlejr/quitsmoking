package dongjoo.second.quitsmoking.ui.base.presenter;

import android.content.Context;

import dongjoo.second.quitsmoking.common.dto.HttpErrorDto;
import dongjoo.second.quitsmoking.ui.base.view.BaseView;


/**
 * BasePresenter
 *
 * @author 김동주
 * @since 2021.10.07
 */

public interface BasePresenter<V extends BaseView> {

    public void onAttach(V baseView);

    public void init();

    public void initView();

    public void onHttpError(HttpErrorDto httpErrorDto);

    public Context getContext();

}
