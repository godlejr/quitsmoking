package dongjoo.second.quitsmoking.ui.home.view;


import dongjoo.second.quitsmoking.ui.base.view.BaseView;

public interface HomeFragmentView extends BaseView {

    void showUserContent();

    void goneUserContent();

    void showUserEmptyContent();

    void goneUserEmptyContent();

    String getmNoticeTvContent();

    void setmNoticeTvContent(String content);

    String getmStartdaysValContent();

    void setmStartdaysValContent(String content);

    String getmQuitperiodValContent();

    void setmQuitperiodValContent(String content);

    String getmLifeValContent();

    void setmLifeValContent(String content);

    String getmMoneyValContent();

    void setmMoneyValContent(String content);

    String getmTv1_20muContent();

    void setmTv1_20muContent(String content);

    String getmTv2_8hContent();

    void setmTv2_8hContent(String content);

    String getmTv3_24hContent();

    void setmTv3_24hContent(String content);

    void setmTv4_48hContent(String content);

    String getmTv5_72h();

    void setmTv5_72hContent(String content);

    String getmTv6_2w();

    void setmTv6_2wContent(String content);

    String getmTv7_3mo();

    void setmTv7_3moContent(String content);

    String getmTv8_9mo();

    void setmTv8_9moContent(String content);

    String getmTv9_1y();

    void setmTv9_1yContent(String content);

    String getmTv10_5y();

    void setmTv10_5yContent(String content);

    String getmTv11_10y();

    void setmTv11_10yContent(String content);

    int getmPg1_20muContent();

    void setmPg1_20muContent(int progress, boolean anim);

    int getmPg2_8hContent();

    void setmPg2_8hContent(int progress, boolean anim);

    int getmPg3_24hContent();

    void setmPg3_24hContent(int progress, boolean anim);

    int getmPg4_48hContent();

    void setmPg4_48hContent(int progress, boolean anim);

    int getmPg5_72hContent();

    void setmPg5_72hContent(int progress, boolean anim);

    int getmPg6_2wContent();

    void setmPg6_2wContent(int progress, boolean anim);

    int getmPg7_3moContent();

    void setmPg7_3moContent(int progress, boolean anim);

    int getmPg8_9moContent();

    void setmPg8_9moContent(int progress, boolean anim);

    int getmPg9_1yContent();

    void setmPg9_1yContent(int progress, boolean anim);

    int getmPg10_5yContent();

    void setmPg10_5yContent(int progress, boolean anim);

    int getmPg11_10yContent();

    void setmPg11_10yContent(int progress, boolean anim);

    void setmTv1_20muTextWithDarkGrayColor();

    void setmTv1_20muTextWithPointColor();

    void setmTv2_8hTextWithDarkGrayColor();

    void setmTv3_24hTextWithDarkGrayColor();

    void setmTv4_48hTextWithDarkGrayColor();

    void setmTv5_72hTextWithDarkGrayColor();

    void setmTv6_2wTextWithDarkGrayColor();

    void setmTv7_3moTextWithDarkGrayColor();

    void setmTv8_9moTextWithDarkGrayColor();

    void setmTv9_1yTextWithDarkGrayColor();

    void setmTv10_5yTextWithDarkGrayColor();

    void setmTv11_10yTextWithDarkGrayColor();

    void setmTv2_8hTextWithPointColor();

    void setmTv3_24hTextWithPointColor();

    void setmTv4_48hTextWithPointColor();

    void setmTv5_72hTextWithPointColor();

    void setmTv6_2wTextWithPointColor();

    void setmTv7_3moTextWithPointColor();

    void setmTv8_9moTextWithPointColor();

    void setmTv9_1yTextWithPointColor();

    void setmTv10_5yTextWithPointColor();

    void setmTv11_10yTextWithPointColor();

    void navigateToUserWriteActivity();
}
