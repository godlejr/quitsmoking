package dongjoo.second.quitsmoking.common.dialog.confirmcancel.view;


import dongjoo.second.quitsmoking.ui.base.view.BaseView;

public interface ConfirmCancelView extends BaseView {
    void setTitleContent(String content);

    void navigateToBackWithResultOk();


    void navigateToBack();
}
