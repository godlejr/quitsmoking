package dongjoo.second.quitsmoking.ui.base.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import dongjoo.second.quitsmoking.R;
import dongjoo.second.quitsmoking.common.entity.History;
import dongjoo.second.quitsmoking.common.entity.User;
import dongjoo.second.quitsmoking.common.utils.ToastUtil;
import dongjoo.second.quitsmoking.repository.local.SharedPreferenceManager;
import dongjoo.second.quitsmoking.ui.base.view.BaseView;

/**
 * BaseFragment
 *
 * @author 김동주
 * @since 2021.10.07
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    protected Context mContext;

    protected ToastUtil toastUtil;

    protected SharedPreferenceManager mSharedPreferenceManager;

    protected ProgressDialog mProgressDialog;

    protected Handler mProgressDialogHandler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
        //toast
        this.toastUtil = new ToastUtil(mContext);

        //sharedPreference
        this.mSharedPreferenceManager = new SharedPreferenceManager(mContext);

        //ProgressDialog
        this.mProgressDialogHandler = new Handler();
        this.mProgressDialog = new ProgressDialog(mContext);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void showMessage(String message) {
        toastUtil.showMessage(message);
    }

    @Override
    public void setToolbarLayout() {

    }

    @Override
    public void showToolbarTitle(String message) {

    }

    @Override
    public void setSharedPreferUser(User user) {
        this.mSharedPreferenceManager.setUser(user);
    }

    @Override
    public User getSharedPreferUser() {
        return this.mSharedPreferenceManager.getUser();
    }

    @Override
    public void removeSharedPreferUser() {
        this.mSharedPreferenceManager.removeUser();
    }

    @Override
    public void setSharedPreferHistory(History history) {
        this.mSharedPreferenceManager.setHistory(history);
    }

    @Override
    public ArrayList<History> getSharedPreferHistories() {
        return this.mSharedPreferenceManager.getHistories();
    }

    @Override
    public void removeSharedPreferHistory(int index) {
        this.mSharedPreferenceManager.removeHistory(index);
    }

    @Override
    public void removeAllSharedPreferHistory(List<History> removeHistories) {
        this.mSharedPreferenceManager.removeAllHistory(removeHistories);
    }

    @Override
    public void setActivityFinish() {
        //fragment는 적용 대상 아님.
    }

    @Override
    public void showProgressDialog() {
        this.mProgressDialog.show();
        if (this.mProgressDialog.getWindow() != null) {
            this.mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        this.mProgressDialog.getWindow().getDecorView().setBackgroundResource(R.color.transparent);
        this.mProgressDialog.setContentView(R.layout.progress_dialog);
    }

    @Override
    public void goneProgressDialog() {
        this.mProgressDialogHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        }, 400);

    }

    protected abstract void init();

    protected abstract void initView();

    @Override
    public Context getContext() {
        return this.mContext;
    }
}
