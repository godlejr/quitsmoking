package dongjoo.second.quitsmoking.ui.home.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dongjoo.second.quitsmoking.R;
import dongjoo.second.quitsmoking.ui.base.fragment.BaseFragment;
import dongjoo.second.quitsmoking.ui.home.presenter.HomeFragmentPresenter;
import dongjoo.second.quitsmoking.ui.home.presenter.HomeFragmentPresenterImpl;
import dongjoo.second.quitsmoking.ui.home.view.HomeFragmentView;
import dongjoo.second.quitsmoking.ui.userwrite.activity.UserWriteActivity;

public class HomeFragment extends BaseFragment implements HomeFragmentView {

    private HomeFragmentPresenter mPresenter;

    @BindView(R.id.tv_homefragment_notice)
    TextView mNoticeTv;


    @BindView(R.id.tv_homefragment_startdays_val)
    TextView mStartdaysVal;

    @BindView(R.id.tv_homefragment_quitperiod_val)
    TextView mQuitperiodVal;

    @BindView(R.id.tv_homefragment_life_val)
    TextView mLifeVal;

    @BindView(R.id.tv_homefragment_money_val)
    TextView mMoneyVal;


    @BindView(R.id.tv_homefragment_val1)
    TextView mTv1_20mu;

    @BindView(R.id.tv_homefragment_val2)
    TextView mTv2_8h;

    @BindView(R.id.tv_homefragment_val3)
    TextView mTv3_24h;

    @BindView(R.id.tv_homefragment_val4)
    TextView mTv4_48h;

    @BindView(R.id.tv_homefragment_val5)
    TextView mTv5_72h;

    @BindView(R.id.tv_homefragment_val6)
    TextView mTv6_2w;

    @BindView(R.id.tv_homefragment_val7)
    TextView mTv7_3mo;

    @BindView(R.id.tv_homefragment_val8)
    TextView mTv8_9mo;

    @BindView(R.id.tv_homefragment_val9)
    TextView mTv9_1y;

    @BindView(R.id.tv_homefragment_val10)
    TextView mTv10_5y;

    @BindView(R.id.tv_homefragment_val11)
    TextView mTv11_10y;


    @BindView(R.id.pg_homefragment_1)
    ProgressBar mPg1_20mu;

    @BindView(R.id.pg_homefragment_2)
    ProgressBar mPg2_8h;

    @BindView(R.id.pg_homefragment_3)
    ProgressBar mPg3_24h;

    @BindView(R.id.pg_homefragment_4)
    ProgressBar mPg4_48h;

    @BindView(R.id.pg_homefragment_5)
    ProgressBar mPg5_72h;

    @BindView(R.id.pg_homefragment_6)
    ProgressBar mPg6_2w;

    @BindView(R.id.pg_homefragment_7)
    ProgressBar mPg7_3mo;

    @BindView(R.id.pg_homefragment_8)
    ProgressBar mPg8_9mo;

    @BindView(R.id.pg_homefragment_9)
    ProgressBar mPg9_1y;

    @BindView(R.id.pg_homefragment_10)
    ProgressBar mPg10_5y;

    @BindView(R.id.pg_homefragment_11)
    ProgressBar mPg11_10y;


    @BindView(R.id.ll_homefragment_user)
    LinearLayout mUser;

    @BindView(R.id.ll_homefragment_userempty)
    LinearLayout mUserEmpty;


    @BindColor(R.color.darkGray)
    int mDarkGrayColor;

    @BindColor(R.color.pointColor)
    int mPointColor;

    @BindView(R.id.adView)
    AdView mAdView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();

        this.mPresenter = new HomeFragmentPresenterImpl<HomeFragmentView>();
        this.mPresenter.onAttach(this);

        init();

        MobileAds.initialize(this.mContext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();

        AdRequest adRequest = new AdRequest.Builder().build();
        this.mAdView.loadAd(adRequest);

        return view;
    }

    @Override
    protected void init() {
        this.mPresenter.init();
    }

    @Override
    protected void initView() {
        this.mPresenter.initView();
    }


    @Override
    public void showUserContent() {
        if (this.mUser.getVisibility() == View.GONE) {
            this.mUser.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void goneUserContent() {
        if (this.mUser.getVisibility() == View.VISIBLE) {
            this.mUser.setVisibility(View.GONE);
        }
    }

    @Override
    public void showUserEmptyContent() {
        if (this.mUserEmpty.getVisibility() == View.GONE) {
            this.mUserEmpty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void goneUserEmptyContent() {
        if (this.mUserEmpty.getVisibility() == View.VISIBLE) {
            this.mUserEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public String getmNoticeTvContent() {
        return this.mNoticeTv.getText().toString();
    }

    @Override
    public void setmNoticeTvContent(String content) {
        this.mNoticeTv.setText(content);
    }

    @Override
    public String getmStartdaysValContent() {
        return this.mStartdaysVal.getText().toString();
    }

    @Override
    public void setmStartdaysValContent(String content) {
        this.mStartdaysVal.setText(content);
    }

    @Override
    public String getmQuitperiodValContent() {
        return mQuitperiodVal.getText().toString();
    }

    @Override
    public void setmQuitperiodValContent(String content) {
        this.mQuitperiodVal.setText(content);
    }

    @Override
    public String getmLifeValContent() {
        return this.mLifeVal.getText().toString();
    }

    @Override
    public void setmLifeValContent(String content) {
        this.mLifeVal.setText(content);
    }

    @Override
    public String getmMoneyValContent() {
        return this.mMoneyVal.getText().toString();
    }

    @Override
    public void setmMoneyValContent(String content) {
        this.mMoneyVal.setText(content);
    }


    //graph
    @Override
    public String getmTv1_20muContent() {
        return this.mTv1_20mu.getText().toString();
    }

    @Override
    public void setmTv1_20muContent(String content) {
        this.mTv1_20mu.setText(content);
    }


    @Override
    public String getmTv2_8hContent() {
        return this.mTv2_8h.getText().toString();
    }

    @Override
    public void setmTv2_8hContent(String content) {
        this.mTv2_8h.setText(content);
    }

    @Override
    public String getmTv3_24hContent() {
        return this.mTv3_24h.getText().toString();
    }

    @Override
    public void setmTv3_24hContent(String content) {
        this.mTv3_24h.setText(content);
    }

    @Override
    public void setmTv4_48hContent(String content) {
        this.mTv4_48h.setText(content);
    }

    @Override
    public String getmTv5_72h() {
        return this.mTv5_72h.getText().toString();
    }

    @Override
    public void setmTv5_72hContent(String content) {
        this.mTv5_72h.setText(content);
    }

    @Override
    public String getmTv6_2w() {
        return this.mTv6_2w.getText().toString();
    }

    @Override
    public void setmTv6_2wContent(String content) {
        this.mTv6_2w.setText(content);
    }

    @Override
    public String getmTv7_3mo() {
        return this.mTv7_3mo.getText().toString();
    }

    @Override
    public void setmTv7_3moContent(String content) {
        this.mTv7_3mo.setText(content);
    }

    @Override
    public String getmTv8_9mo() {
        return this.mTv7_3mo.getText().toString();
    }

    @Override
    public void setmTv8_9moContent(String content) {
        this.mTv8_9mo.setText(content);
    }

    @Override
    public String getmTv9_1y() {
        return this.mTv9_1y.getText().toString();
    }

    @Override
    public void setmTv9_1yContent(String content) {
        this.mTv9_1y.setText(content);
    }

    @Override
    public String getmTv10_5y() {
        return this.mTv10_5y.getText().toString();
    }

    @Override
    public void setmTv10_5yContent(String content) {
        this.mTv10_5y.setText(content);
    }

    @Override
    public String getmTv11_10y() {
        return this.mTv11_10y.getText().toString();
    }

    @Override
    public void setmTv11_10yContent(String content) {
        this.mTv11_10y.setText(content);
    }

    @Override
    public int getmPg1_20muContent() {
        return this.mPg1_20mu.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg1_20muContent(int progress, boolean anim) {
        this.mPg1_20mu.setProgress(progress, anim);
    }

    @Override
    public int getmPg2_8hContent() {
        return this.mPg2_8h.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg2_8hContent(int progress, boolean anim) {
        this.mPg2_8h.setProgress(progress, anim);

    }

    @Override
    public int getmPg3_24hContent() {
        return this.mPg3_24h.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg3_24hContent(int progress, boolean anim) {
        this.mPg3_24h.setProgress(progress, anim);

    }

    @Override
    public int getmPg4_48hContent() {
        return this.mPg4_48h.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg4_48hContent(int progress, boolean anim) {
        this.mPg4_48h.setProgress(progress, anim);

    }

    @Override
    public int getmPg5_72hContent() {
        return this.mPg5_72h.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg5_72hContent(int progress, boolean anim) {
        this.mPg5_72h.setProgress(progress, anim);

    }

    @Override
    public int getmPg6_2wContent() {
        return this.mPg6_2w.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg6_2wContent(int progress, boolean anim) {
        this.mPg6_2w.setProgress(progress, anim);

    }

    @Override
    public int getmPg7_3moContent() {
        return this.mPg7_3mo.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg7_3moContent(int progress, boolean anim) {
        this.mPg7_3mo.setProgress(progress, anim);

    }

    @Override
    public int getmPg8_9moContent() {
        return this.mPg8_9mo.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg8_9moContent(int progress, boolean anim) {
        this.mPg8_9mo.setProgress(progress, anim);

    }

    @Override
    public int getmPg9_1yContent() {
        return this.mPg9_1y.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg9_1yContent(int progress, boolean anim) {
        this.mPg9_1y.setProgress(progress, anim);

    }

    @Override
    public int getmPg10_5yContent() {
        return this.mPg10_5y.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg10_5yContent(int progress, boolean anim) {
        this.mPg10_5y.setProgress(progress, anim);

    }

    @Override
    public int getmPg11_10yContent() {
        return this.mPg11_10y.getProgress();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setmPg11_10yContent(int progress, boolean anim) {
        this.mPg11_10y.setProgress(progress, anim);

    }

    @Override
    public void setmTv1_20muTextWithDarkGrayColor() {
        this.mTv1_20mu.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv2_8hTextWithDarkGrayColor() {
        this.mTv2_8h.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv3_24hTextWithDarkGrayColor() {
        this.mTv3_24h.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv4_48hTextWithDarkGrayColor() {
        this.mTv4_48h.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv5_72hTextWithDarkGrayColor() {
        this.mTv5_72h.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv6_2wTextWithDarkGrayColor() {
        this.mTv6_2w.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv7_3moTextWithDarkGrayColor() {
        this.mTv7_3mo.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv8_9moTextWithDarkGrayColor() {
        this.mTv8_9mo.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv9_1yTextWithDarkGrayColor() {
        this.mTv9_1y.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv10_5yTextWithDarkGrayColor() {
        this.mTv10_5y.setTextColor(mDarkGrayColor);
    }

    @Override
    public void setmTv11_10yTextWithDarkGrayColor() {
        this.mTv11_10y.setTextColor(mDarkGrayColor);
    }



    @Override
    public void setmTv1_20muTextWithPointColor() {
        this.mTv1_20mu.setTextColor(mPointColor);
    }

    @Override
    public void setmTv2_8hTextWithPointColor() {
        this.mTv2_8h.setTextColor(mPointColor);
    }

    @Override
    public void setmTv3_24hTextWithPointColor() {
        this.mTv3_24h.setTextColor(mPointColor);
    }

    @Override
    public void setmTv4_48hTextWithPointColor() {
        this.mTv4_48h.setTextColor(mPointColor);
    }

    @Override
    public void setmTv5_72hTextWithPointColor() {
        this.mTv5_72h.setTextColor(mPointColor);
    }

    @Override
    public void setmTv6_2wTextWithPointColor() {
        this.mTv6_2w.setTextColor(mPointColor);
    }

    @Override
    public void setmTv7_3moTextWithPointColor() {
        this.mTv7_3mo.setTextColor(mPointColor);
    }

    @Override
    public void setmTv8_9moTextWithPointColor() {
        this.mTv8_9mo.setTextColor(mPointColor);
    }

    @Override
    public void setmTv9_1yTextWithPointColor() {
        this.mTv9_1y.setTextColor(mPointColor);
    }

    @Override
    public void setmTv10_5yTextWithPointColor() {
        this.mTv10_5y.setTextColor(mPointColor);
    }

    @Override
    public void setmTv11_10yTextWithPointColor() {
        this.mTv11_10y.setTextColor(mPointColor);
    }






    @OnClick(R.id.tv_homefragment_userwrite)
    public void onClickUserWrite(){
        this.mPresenter.onClickUserWrite();
    }

    @Override
    public void navigateToUserWriteActivity() {
        Intent intent = new Intent(this.mContext, UserWriteActivity.class);
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();

        this.mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mPresenter.onPause();
    }


}
