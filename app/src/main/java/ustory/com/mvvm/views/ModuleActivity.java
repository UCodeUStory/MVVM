package ustory.com.mvvm.views;

import android.os.Bundle;
import android.view.View;

import ustory.com.mvvm.ModuleActivityBinding;
import ustory.com.mvvm.R;
import ustory.com.mvvm.core.AbsActivity;
import ustory.com.mvvm.services.IPModule;

public class ModuleActivity extends AbsActivity<ModuleActivityBinding> {
    @Override
    protected int setLayoutId() {
        return R.layout.activity_module;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setTitle("Module 使用");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_dialog:
                //ShowDialog dialog = new ShowDialog(this);
                //dialog.show(getSupportFragmentManager(), "testDialog");
                break;
            case R.id.get_ip_info:
                /**
                 * 通过反射机制简化创建过程成，通过泛型给M添加约束
                 * 通过工厂创建，同时将module委托给Ioc,并设置监听事件
                 */
                getModule(IPModule.class).getIpInfo();
                break;

        }
    }

    @Override
    protected void dataCallback(int resultCode, Object data) {
        if (resultCode == 1) {
            //这里是有个强转的过程的
            getBinding().setStr(data +"");
        } else if (resultCode == 2) {
            getBinding().setDialogStr(data + "");
        }
    }


}
