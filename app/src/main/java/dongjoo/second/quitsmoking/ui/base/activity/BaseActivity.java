package dongjoo.second.quitsmoking.ui.base.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import dongjoo.second.quitsmoking.R;
import dongjoo.second.quitsmoking.common.entity.History;
import dongjoo.second.quitsmoking.common.entity.User;
import dongjoo.second.quitsmoking.common.utils.ToastUtil;
import dongjoo.second.quitsmoking.repository.local.SharedPreferenceManager;
import dongjoo.second.quitsmoking.ui.base.view.BaseView;


/**
 * BaseActivity
 *
 * @author 김동주
 * @since 2021.10.06
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Context mContext;

    protected ToastUtil toastUtil;

    protected SharedPreferenceManager mSharedPreferenceManager;

    protected ProgressDialog mProgressDialog;

    protected Handler mProgressDialogHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = BaseActivity.this;

        //toast
        this.toastUtil = new ToastUtil(this);

        //sharedPreference
        this.mSharedPreferenceManager = new SharedPreferenceManager(this);

        //ProgressDialog
        this.mProgressDialog = new ProgressDialog(this);

        this.mProgressDialogHandler = new Handler();


    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void showMessage(String message) {
        toastUtil.showMessage(message);
    }


    @Override
    public void setToolbarLayout() {

    }

    @Override
    public void setActivityFinish() {
        finish();
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
    public void showProgressDialog() {
        this.mProgressDialog.show();
        if (this.mProgressDialog.getWindow() != null) {
            this.mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        this.mProgressDialog.getWindow().getDecorView().setBackgroundResource(R.color.transparent);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        this.mProgressDialog.setContentView(R.layout.progress_dialog);

    }

    @Override
    public void goneProgressDialog() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }




    protected abstract void init();

    @Override
    public Context getContext() {
        return this.mContext;
    }
}
