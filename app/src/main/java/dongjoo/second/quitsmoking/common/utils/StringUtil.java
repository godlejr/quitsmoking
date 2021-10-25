package dongjoo.second.quitsmoking.common.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {

    public static String getWonMoneyFormatByPriceAndCurrCd(float price, String currCd) {

        if ("KRW".equals(currCd)) {
            int money = (int) price;

            String pattern = "###,###;-###,###";

            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
            decimalFormat.applyPattern(pattern);

            String formattedStringPrice = decimalFormat.format(money);
            return formattedStringPrice;
        } else {
            return String.valueOf(price);
        }
    }

    public static String getWonMoneyFormatByIntegerPriceAndCurrCd(Integer price, String currCd) {

        if ("KRW".equals(currCd)) {
            int money = price;

            String pattern = "###,###;-###,###";

            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
            decimalFormat.applyPattern(pattern);

            String formattedStringPrice = decimalFormat.format(money);
            return formattedStringPrice;
        } else {
            return String.valueOf(price);
        }
    }

    public static String getCurrentFormatByCurrCd(String currCd) {
        String current = "KRW";
        if ("KRW".equals(currCd)) {
            current = "원";
        }
        return current;
    }

    public static String getCalculateDateFormatByDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            //
        }
        String message = null;


        simpleDateFormat = new SimpleDateFormat("yyyy년mm월dd일");
        message = simpleDateFormat.format(date);

        return message;
    }

    public static String getTodayWithHyphen() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);

        return today;
    }

    public static String getToday() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = simpleDateFormat.format(date);

        return today;
    }

    public static String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        String time = simpleDateFormat.format(date);

        return time;
    }

    public static String getQuitSmokingStatement() {

        String[] quitSmokingStatements = {
                "담배, 그거 독약입니다", "결코 흡연하지 말라", "흡연이 스트레스의 원인이다", "금연은 마라톤과도 같다", "죽을 때까지 참아야 한다", "흡연이 인명을 살상시킨다", "담배는 사랑의 무덤이다", "담배는 악마의 잡초다", "코로 생명을 태우지마라", "금연만큼 쉬운 일은 없다", "흡연은 확실한 자살 행위"
        };
        Random rd = new Random();
        String stmt = quitSmokingStatements[rd.nextInt(11)];

        return stmt;

    }


}
