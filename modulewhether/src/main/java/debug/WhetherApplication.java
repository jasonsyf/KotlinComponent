package debug;


import com.alibaba.android.arouter.launcher.ARouter;
import com.jason_sunyf.core.appbase.BaseApplication;
import com.jason_sunyf.core.util.X;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:09
 * @version V1.2.0
 * @name WhetherApplication
 */
public class WhetherApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        X.Ext.init(this);
        ARouter.init(this);
    }
}
