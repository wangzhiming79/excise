package bill.edu.excise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.blankj.utilcode.util.ActivityUtils;


public class MainActivity extends BaseActivity {

    final static String FUNC_FRAGMENT = "fragment";
    final static String FUNC_ANIMATION = "animation";
    final static String FUNC_OTHER = "other";

    String items [] = {FUNC_FRAGMENT, FUNC_ANIMATION, FUNC_OTHER};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.activity_main);

        ListView listView = findView(R.id.lstMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtContent, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String func = items[position];
                switch (func){
                    case FUNC_FRAGMENT:
                        ActivityUtils.startActivity(FragmentDemo.class);
                        break;
                    case FUNC_ANIMATION:
                        break;
                    case FUNC_OTHER:
                        default:
                        break;
                }

            }
        });
    }
}
