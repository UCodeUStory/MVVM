package ustory.com.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ustory.com.mvvm.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ustory.com.mvvm.MainActivityBinding mainActivityBinding
                    = DataBindingUtil.setContentView(this,R.layout.activity_main);

        User user = new User();
        user.setName("ustory");
        user.setAge("123");
        mainActivityBinding.setUser(user);
    }
}
