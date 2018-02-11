package bill.edu.excise;

import android.content.Context;
import android.view.View;

import com.ab.activity.AbActivity;
import com.ab.view.titlebar.AbTitleBar;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

/**
 * Created by billwang  on 2016/2/2.
 */
public class BaseActivity extends AbActivity {

    protected AbTitleBar mAbTitleBar = null;


    protected void setTitleBar(int resId){
        mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(resId);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.drawable.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.drawable.line);
    }

    protected void setTitleBar(String title){
        mAbTitleBar = this.getTitleBar();
        mAbTitleBar.setTitleText(title);
        mAbTitleBar.setLogo(R.drawable.button_selector_back);
        mAbTitleBar.setTitleBarBackground(R.drawable.top_bg);
        mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
        mAbTitleBar.setLogoLine(R.drawable.line);
    }




    //    在子类直接 find就可以了
    protected <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 页面开始
        onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        // 页面结束
        onPause(this);
    }


    public static void initMob(Context context, boolean debug){

        MobclickAgent.setDebugMode(debug);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        MobclickAgent.openActivityDurationTrack(true);
        // MobclickAgent.setAutoLocation(true);
        // MobclickAgent.setSessionContinueMillis(1000);
        // MobclickAgent.startWithConfigure(
        // new UMAnalyticsConfig(mContext, "4f83c5d852701564c0000011", "Umeng",
        // EScenarioType.E_UM_NORMAL));
        MobclickAgent.setScenarioType(context, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    /**
     * for fragment
     * @param value
     */
    public static void openActivityDurationTrack(boolean value){
        MobclickAgent.openActivityDurationTrack(value);
    }

    public static void onPageStart(String pageName){
        MobclickAgent.onPageStart(pageName);
    }

    public static void onPageEnd(String pageName){
        MobclickAgent.onPageEnd(pageName);
    }

    public static void onResume(Context context){
        MobclickAgent.onResume(context);
    }

    public static void onPause(Context context){
        MobclickAgent.onPause(context);
    }

    public static void addStatEvent(Context context, String eventId) {
        MobclickAgent.onEvent(context, eventId);
    }

    public static void addStatEvent(Context context, String eventId, HashMap map) {
        MobclickAgent.onEvent(context, eventId, map);
    }

    public static void addStatEvent(Context context, String eventId, HashMap map, int duration) {
        MobclickAgent.onEventValue(context, eventId, map, duration);
    }


    //   使用自定义事件的依赖条件
    //	使用自定义事件功能请先登陆友盟官网 
    //  在 “统计分析->设置->事件” （子账户由于权限限制可能无法看到“设置”选项，请联系主帐号开通权限。）页面中添加相应的事件id（事件id可用英文或数字，不要使用中文和特殊字符且不能使用英文句号“.”您可以使用下划线“_”），然后服务器才会对相应的事件请求进行处理。
    //  自定义事件的代码需要放在Activity里的onResume--onPause之间，请在友盟初始化之后调用事件,不支持在service中统计。

    /**
     * 统计发生次数
     * 使用计数事件需要在后台添加事件时选择“计数事件”。
     * @param eventId
     */
    public void addStatEvent(String eventId) {
        addStatEvent(this, eventId);
    }

    /**
     * 考虑事件在不同属性上的取值
     * HashMap<String,String> map = new HashMap<String,String>();
     * map.put("type","book");
     * map.put("quantity","3");
     * @param eventId
     * @param map
     */
    public void addStatEvent(String eventId, HashMap map){
        addStatEvent(this, eventId, map);
    }

//    统计一个数值类型的连续变量（该变量必须为整数），用户每次触发的数值的分布情况，如事件持续时间、每次付款金额等，可以调用如下方法：
//    MobclickAgent.onEventValue(Context context, String id, Map<String,String> m, int du)
//    id 为事件ID map 为当前事件的属性和取值 du 为当前事件的数值为当前事件的数值，取值范围是-2,147,483,648 到 +2,147,483,647 之间的有符号整数，即int 32类型，如果数据超出了该范围，会造成数据丢包，影响数据统计的准确性。
//    示例：统计一次音乐播放，包括音乐类型，作者和播放时长，可以在音乐播放结束后这么调用：
//    int duration = 12000; //开发者需要自己计算音乐播放时长
//　　Map<String, String> map_value = new HashMap<String, String>();
//　　map_value.put("type" , "popular" );
//　　map_value.put("artist" , "JJLin" );

    /**
     * 统计一个数值类型的连续变量
     * @param eventId
     * @param map
     * @param duration
     */
    public void addStatEvent(String eventId, HashMap map, int duration){
        addStatEvent(this, eventId, map, duration);
    }
}
