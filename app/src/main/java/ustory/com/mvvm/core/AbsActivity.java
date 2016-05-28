package ustory.com.mvvm.core;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ustory.com.mvvm.utils.StringUtil;
import ustory.com.mvvm.utils.T;


/**
 * Create by qiyue 2016/5/28
 * 所有的 Activity都应该继承这个类
 * implements OnTempBtClickListener
 */
public abstract class AbsActivity<VB extends ViewDataBinding> extends AppCompatActivity {
    protected String TAG = "";
    private VB mBind;
    private IOCProxy mProxy;
    /**
     * 第一次点击返回的系统时间
     */
    private long mFirstClickTime = 0;
    protected ManagerActivity mAm;
    protected View mRootView;
    private ModuleFactory mModuleF;
    //protected AbsTempView mTempView;
    protected boolean useTempView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
        init(savedInstanceState);
    }

    private void initialization() {
        mAm = ManagerActivity.getInstance();
        mAm.addActivity(this);
        mBind = DataBindingUtil.setContentView(this, setLayoutId());
        /**
         * 将自身委托给IOC容器，任凭他的处置，
         */
        mProxy = IOCProxy.newInstance(this);
        TAG = StringUtil.getClassName(this);
        mModuleF = ModuleFactory.newInstance();
        //ButterKnife.inject(this);
        mRootView = findViewById(android.R.id.content);
      /*  if (useTempView) {
            mTempView = new TempView(this);
            mTempView.setBtListener(this);
        }*/
    }

   /* *//**
     * 获取填充View
     *//*
    protected AbsTempView getTempView() {
        return mTempView;
    }*/

    /**
     * 是否使用填充界面
     *
     * @param useTempView
     */
    protected void setUseTempView(boolean useTempView) {
        this.useTempView = useTempView;
    }

    /**
     * 设置自定义的TempView
     *
     * @param tempView
     */
   /* protected void setCustomTempView(AbsTempView tempView) {
        mTempView = tempView;
        mTempView.setBtListener(this);
    }*/

    /**
     * 显示占位布局
     *
     * @param type {@link TempView#ERROR}
     *             {@link TempView#DATA_NULL}
     *             {@link TempView#LOADING}
     */
  /*  protected void showTempView(int type) {
        if (mTempView == null || !useTempView) {
            return;
        }
        mTempView.setVisibility(View.VISIBLE);
        mTempView.setType(type);
        setContentView(mTempView);
    }*/

    /**
     * 关闭占位布局
     */
   /* protected void hintTempView() {
        hintTempView(0);
    }*/

    /**
     * 延时关闭占位布局
     */
   /* protected void hintTempView(int delay) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mTempView == null || !useTempView) {
                    return;
                }
                mTempView.clearFocus();
                mTempView.setVisibility(View.GONE);
                mBind = DataBindingUtil.setContentView(AbsActivity.this, setLayoutId());
            }
        }, delay);
    }*/

   /* @Override
    public void onBtTempClick(View view, int type) {

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected void init(Bundle savedInstanceState) {

    }

    @Override
    public void finish() {
        super.finish();
        mAm.removeActivity(this);
        System.gc();
    }

    public View getRootView() {
        return mRootView;
    }

    /**
     * 设置资源布局
     *
     * @return
     */
    protected abstract int setLayoutId();

    /**
     * 获取binding对象
     */
    protected VB getBinding() {
        return mBind;
    }

    /**
     * 获取Module
     *
     * @param clazz {@link AbsModule}
     */
    protected <M extends AbsModule> M getModule(Class<M> clazz) {
        M module = mModuleF.getModule(this, clazz);
        mProxy.changeModule(module);
        //这里可以让ABSActivity 实现一个监听，然后直接传递一个module，
        // 在实现方法里调用抽象方法，在实现类的Activity实现这个方法；
        return module;
    }

    /**
     * 数据回调
     *
     * @param result
     * @param data
     */
    protected abstract void dataCallback(int result, Object data);

    /**
     * 双击退出
     */
    private boolean onDoubleClickExit(long timeSpace) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mFirstClickTime > timeSpace) {
            T.showShort(this, "再按一次退出");
            mFirstClickTime = currentTimeMillis;
            return false;
        } else {
            return true;
        }
    }

    /**
     * 双击退出，间隔时间为2000ms
     *
     * @return
     */
    public boolean onDoubleClickExit() {
        return onDoubleClickExit(2000);
    }

    /**
     * 退出应用程序
     *
     * @param isBackground 是否开开启后台运行,如果为true则为后台运行
     */
    public void exitApp(Boolean isBackground) {
        mAm.exitApp(isBackground);
    }

    /**
     * 退出应用程序
     */
    public void exitApp() {
        mAm.exitApp(false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      //  PermissionHelp.getInstance().handlePermissionCallback(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       // PermissionHelp.getInstance().handleSpecialPermissionCallback(this, requestCode, resultCode, data);
    }
}