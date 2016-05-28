package ustory.com.mvvm.core;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        MVVMFrame.init(this).openCrashHandler();
//        MVVMFrame.init(this).openCrashHandler("http://192.168.2.183/server.php", "params");
        ManagerActivity.init(this);
    }
}