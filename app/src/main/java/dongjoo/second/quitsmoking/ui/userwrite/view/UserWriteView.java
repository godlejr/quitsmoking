package dongjoo.second.quitsmoking.ui.userwrite.view;


import dongjoo.second.quitsmoking.ui.base.view.BaseView;

public interface UserWriteView extends BaseView {

    void setDatePickerDialog(int year, int month, int day);

    void setTimePickerDialog(int hour, int minute, boolean is24);

    String getUserWriteTitle();

    void setmDateTvContent(String content);

    void setmTimeTvContent(String content);

    void setmCountEtContent(String content);

    void setmPriceEtContent(String content);

    void showTimePickDialog();

    void showDatePickDialog();

    String getmDateTvContent();

    String getmTimeTvContent();

    String getmCountEtContent();

    String getmPriceEtContent();

    void onBackBtnClick();
}
