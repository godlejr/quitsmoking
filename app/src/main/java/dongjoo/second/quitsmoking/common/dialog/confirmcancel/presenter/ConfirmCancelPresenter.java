package dongjoo.second.quitsmoking.common.dialog.confirmcancel.presenter;


import dongjoo.second.quitsmoking.common.dialog.confirmcancel.view.ConfirmCancelView;
import dongjoo.second.quitsmoking.common.dto.ConfirmCancelDialogDto;
import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenter;

public interface ConfirmCancelPresenter<V extends ConfirmCancelView> extends BasePresenter<V> {
    void init(ConfirmCancelDialogDto confirmCancelDialogDto, int flag);

    void onClickConfirm();

    void onClickCancel();

    void onAdDismissedFullScreenContent();
}
