package dongjoo.second.quitsmoking.ui.setting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dongjoo.second.quitsmoking.R;
import dongjoo.second.quitsmoking.ui.base.fragment.BaseFragment;
import dongjoo.second.quitsmoking.ui.setting.presenter.SettingFragmentPresenter;
import dongjoo.second.quitsmoking.ui.setting.presenter.SettingFragmentPresenterImpl;
import dongjoo.second.quitsmoking.ui.setting.view.SettingFragmentView;
import dongjoo.second.quitsmoking.ui.userwrite.activity.UserWriteActivity;

public class SettingFragment extends BaseFragment implements SettingFragmentView {

    private SettingFragmentPresenter mPresenter;


    @BindString(R.string.dev_email)
    String devEmail;

    @BindView(R.id.ll_setting_mail)
    LinearLayout mMail;

    @BindView(R.id.ll_setting_promotion)
    LinearLayout mPromotion;

    @BindView(R.id.ll_setting_userwrite)
    LinearLayout mUserwrite;

    @BindView(R.id.ll_setting_comment)
    LinearLayout mComment;


    @BindColor(R.color.darkGray)
    int mDarkGrayColor;

    @BindView(R.id.adView)
    AdView mAdView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();

        this.mPresenter = new SettingFragmentPresenterImpl<SettingFragmentView>();
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
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
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


    @OnClick(R.id.ll_setting_userwrite)
    public void onClickUserWrite(){
        this.mPresenter.onClickUserWrite();
    }

    @OnClick(R.id.ll_setting_mail)
    public void onClickMail(){
        this.mPresenter.onClickMail();
    }


    @OnClick(R.id.ll_setting_promotion)
    public void onClickPromotion(){
        this.mPresenter.onClickPromotion();
    }

    @OnClick(R.id.ll_setting_comment)
    public void onClickComment(){
        this.mPresenter.onClickComment();
    }

    @Override
    public void navigateToUserWriteActivity() {
        Intent intent = new Intent(this.mContext, UserWriteActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToDevEmail(){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("plain/text");
        String[] address = {devEmail};
        email.putExtra(Intent.EXTRA_EMAIL, address);
        email.putExtra(Intent.EXTRA_SUBJECT, "[초간단 금연일기 앱 문의]");
        email.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(email);
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
