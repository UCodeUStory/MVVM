package ustory.com.mvvm.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ustory.com.mvvm.MainActivityBinding;
import ustory.com.mvvm.R;
import ustory.com.mvvm.core.AbsActivity;
import ustory.com.mvvm.model.User;
import ustory.com.mvvm.services.IPModule;

public class MainActivity extends AbsActivity<MainActivityBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
    /*    ustory.com.mvvm.MainActivityBinding mainActivityBinding
                = DataBindingUtil.setContentView(this,R.layout.activity_main);
*/
        User user = new User();
        user.setName("ustory");
        user.setAge("123");
        getBinding().setUser(user);
    }

    @Override
    protected void dataCallback(int result, Object data) {

    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.get_ip_info:
                getModule(IPModule.class).getIpInfo();
                startActivity(new Intent(this,ModuleActivity.class));
                break;

        }
    }
}
