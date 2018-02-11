package bill.edu.excise;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;

public class MyApplication extends Application {

    public static String deviceToken = "unknown";
    public static String userToken = null;
    public static String umKey = "5a7d094fa40fa34488000014";


    @Override
    public void onCreate() {
        super.onCreate();

       // userToken = AbSharedUtil.getString(this, ConstValue.TOKEN_COOKIE);

        //AdEngine.createInstance(this);

        Utils.init(this);

        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:友盟 app key
         * 参数3:友盟 channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this, umKey, null, UMConfigure.DEVICE_TYPE_PHONE, null);

        //Fresco库的初始化,要先初始化库，才能完成布局文件的加载
        Fresco.initialize(this);//初始化框架

//        LogUtils.d("App run");
//        LogUtils.json("{name:'bill'}");
//        testLog();

    }


    public static boolean isLogin(){
        return userToken != null;
    }

    public static String getUserToken() {
        return userToken;

    }



}
