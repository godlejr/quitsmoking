package dongjoo.second.quitsmoking.ui.home.presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dongjoo.second.quitsmoking.common.entity.User;
import dongjoo.second.quitsmoking.common.utils.StringUtil;
import dongjoo.second.quitsmoking.ui.base.presenter.BasePresenterImpl;
import dongjoo.second.quitsmoking.ui.home.view.HomeFragmentView;


public class HomeFragmentPresenterImpl<V extends HomeFragmentView> extends BasePresenterImpl<V> implements HomeFragmentPresenter<V> {

//    private HomeFragmentInteractor mInteractor;

    public HomeFragmentPresenterImpl() {
    }


    @Override
    public void init() {
//        this.mInteractor = new HomeFragmentInteractorImpl<HomeFragmentPresenter>();
//        this.mInteractor.onAttach(this);
    }

    @Override
    public void initView() {

        //명언 투척
        getBaseView().setmNoticeTvContent(StringUtil.getQuitSmokingStatement());

        User user = getBaseView().getSharedPreferUser();

        int year = 0;
        int month = 0;
        int day = 0;
        int meanOfSmoking = 0;
        int costOfSmoking = 0;

        if (user != null) {

            getBaseView().goneUserEmptyContent();
            getBaseView().showUserContent();

            year = user.getYear();
            month = user.getMonth();
            day = user.getDay();
            meanOfSmoking = user.getMeanOfSmoking();
            costOfSmoking = user.getCostOfSmoking();

            String startdaysVal = year + "년 " + month + "월 " + day + "일";

            //금연일자
            getBaseView().setmStartdaysValContent(startdaysVal);


            //날짜 시간 차이
            String startDays = user.getStartDays();
            int hour = user.getHour();
            int minute = user.getMinute();

            Calendar getToday = Calendar.getInstance();
            getToday.setTime(new Date()); //금일 날짜

            String s_date = startDays + " " + hour + ":" + minute;//"yyyy-MM-dd"
            Date date = null;

            try {
                date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(s_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar cmpDate = Calendar.getInstance();
            cmpDate.setTime(date); //특정 일자

            long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
            long diffDays = diffSec / (24 * 60 * 60); //일자수 차이
            long diffHours = (diffSec / (60 * 60)); //시간 차이
            long diffMinutes = (diffSec / (60)); //분 차이

            long diffHoursMod = (diffSec / (60 * 60)) % 24; //시간 차이
            long diffMinutesMod = (diffSec / (60)) % 60; //분 차이

            String quitPeriodVal = diffHoursMod + "시간 " + diffMinutesMod + "분 째";

            if (diffDays > 0 || diffDays < 0) {
                quitPeriodVal = diffDays + "일 " + diffHoursMod + "시간 " + diffMinutesMod + "분 째";
            }

            getBaseView().setmQuitperiodValContent(quitPeriodVal);


            //연장 수명 (나누기 8)
            long lifeSec = diffSec / 8;
            long lifeDays = lifeSec / (24 * 60 * 60); //일자수 차이
            long lifeHours = (lifeSec / (60 * 60)); //시간 차이
            long lifeMinutes = (lifeSec / (60));  //분 차이


            long lifeHoursMod = (lifeSec / (60 * 60)) % 24; //시간 차이
            long lifeMinutesMod = (lifeSec / (60)) % 60; //분 차이

            String lifeVal = lifeHoursMod + "시간 " + lifeMinutesMod + "분 연장";

            if (lifeDays > 0 || lifeDays < 0) {
                lifeVal = lifeDays + "일 " + lifeHoursMod + "시간 " + lifeMinutesMod + "분 연장";
            }

            getBaseView().setmLifeValContent(lifeVal);


            //아낀돈
            long money = costOfSmoking * meanOfSmoking / 20;

            if (diffDays > 0) {
                money *= diffDays;
            }

            String moneyVal = StringUtil.getWonMoneyFormatByPriceAndCurrCd(money, "KRW") + "원";
            getBaseView().setmMoneyValContent(moneyVal);


            //그래프
            //애니 메이션
            boolean isAnim = true;

            double per1 = (((double)diffMinutes / 20) * 100);

            if (per1 < 100) {
                getBaseView().setmTv1_20muTextWithDarkGrayColor();
                getBaseView().setmTv1_20muContent((int) per1 + "%");
                getBaseView().setmPg1_20muContent((int) per1, isAnim);
            }

            double per2 = (((double)diffMinutes / (8 * 60)) * 100);

            if (per2 < 100) {

                getBaseView().setmTv2_8hTextWithDarkGrayColor();
                getBaseView().setmTv2_8hContent((int) per2 + "%");
                getBaseView().setmPg2_8hContent((int) per2, isAnim);
            }


            double per3 = (((double)diffMinutes / (24 * 60)) * 100);
            if (per3 < 100) {
                getBaseView().setmTv3_24hTextWithDarkGrayColor();
                getBaseView().setmTv3_24hContent((int) per3 + "%");
                getBaseView().setmPg3_24hContent((int) per3, isAnim);
            }

            double per4 = (((double)diffMinutes / (2 * 24 * 60)) * 100);
            if (per4 < 100) {
                getBaseView().setmTv4_48hTextWithDarkGrayColor();
                getBaseView().setmTv4_48hContent((int) per4 + "%");
                getBaseView().setmPg4_48hContent((int) per4, isAnim);
            }


            double per5 = (((double)diffMinutes / (3 * 24 * 60)) * 100);
            if (per5 < 100) {
                getBaseView().setmTv5_72hTextWithDarkGrayColor();
                getBaseView().setmTv5_72hContent((int) per5 + "%");
                getBaseView().setmPg5_72hContent((int) per5, isAnim);
            }

            double per6 = (((double)diffMinutes / (14 * 24 * 60)) * 100);
            if (per6 < 100) {
                getBaseView().setmTv6_2wTextWithDarkGrayColor();
                getBaseView().setmTv6_2wContent((int) per6 + "%");
                getBaseView().setmPg6_2wContent((int) per6, isAnim);
            }

            double per7 = (((double)diffMinutes / (90 * 24 * 60)) * 100);
            if (per7 < 100) {
                getBaseView().setmTv7_3moTextWithDarkGrayColor();
                getBaseView().setmTv7_3moContent((int) per7 + "%");
                getBaseView().setmPg7_3moContent((int) per7, isAnim);
            }

            double per8 = (((double)diffMinutes / (270 * 24 * 60)) * 100);
            if (per8 < 100) {
                getBaseView().setmTv8_9moTextWithDarkGrayColor();
                getBaseView().setmTv8_9moContent((int) per8 + "%");
                getBaseView().setmPg8_9moContent((int) per8, isAnim);
            }

            double per9 = (((double)diffMinutes / (365 * 24 * 60)) * 100);
            if (per9 < 100) {
                getBaseView().setmTv9_1yTextWithDarkGrayColor();
                getBaseView().setmTv9_1yContent((int) per9 + "%");
                getBaseView().setmPg9_1yContent((int) per9, isAnim);
            }

            double per10 = (((double)diffMinutes / (5 * 365 * 24 * 60)) * 100);
            if (per10 < 100) {
                getBaseView().setmTv10_5yTextWithDarkGrayColor();
                getBaseView().setmTv10_5yContent((int) per10 + "%");
                getBaseView().setmPg10_5yContent((int) per10, isAnim);
            }

            double per11 = (((double)diffMinutes / (10 * 365 * 24 * 60)) * 100);
            if (per11 < 100) {
                getBaseView().setmTv11_10yTextWithDarkGrayColor();
                getBaseView().setmTv11_10yContent((int) per11 + "%");
                getBaseView().setmPg11_10yContent((int) per11, isAnim);
            }

        } else {

            getBaseView().goneUserContent();
            getBaseView().showUserEmptyContent();

        }


    }


    @Override
    public void onPause() {
        //fragment pause flag setting
//        boolean isHomeFragmentPause = this.mInteractor.isHomeFragmentPause();
//
//        if (!isHomeFragmentPause) {
//            this.mInteractor.setHomeFragmentPause(true);
//        }
    }

    @Override
    public void onResume() {
        initView();
    }

    @Override
    public void onClickUserWrite() {
        getBaseView().navigateToUserWriteActivity();
    }
}
