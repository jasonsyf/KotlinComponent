package debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jason_sunyf.core.appbase.BaseApplication;
import com.jason_sunyf.core.util.X;

/**
 * @author : Jason_Sunyf
 * @date : 2017/12/19 0019  下午 2:32
 * @Email : jason_sunyf@163.com
 */

public class TrafficApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        X.Ext.init(this);
        ARouter.init(this);
    }
}
