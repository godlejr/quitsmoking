package dongjoo.second.quitsmoking.ui.main.view;

import dongjoo.second.quitsmoking.common.dto.ConfirmCancelDialogDto;
import dongjoo.second.quitsmoking.ui.base.view.BaseView;

public interface MainView extends BaseView {

  //  void navigateToConfirmCancelDialogActivity(ConfirmCancelDialogDto confirmCancelDialogDto, int flag, int requestCode);

    void setTabLayout();

    void setTabAdapter();

    String getMainTitle();

    void destroyApp();

    void navigateToConfirmCancelDialogActivity(ConfirmCancelDialogDto confirmCancelDialogDto, int flag, int requestCode);

    //void showRequestPermissions();
}
