package bill.edu.excise;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.blankj.utilcode.util.FragmentUtils;

import bill.edu.excise.dummy.DummyContent;

/**
 * Created by Bill on 2018/2/9.
 */

public class FragmentDemo extends BaseActivity implements ItemFragment.OnListFragmentInteractionListener, ListFragment.OnListFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener {


    private ItemFragment itemFragment;
    private ListFragment listFragment;
    private BlankFragment blankFragment;

    private Fragment cur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.activity_fragment);

        FragmentManager fragmentMng = getSupportFragmentManager();
        itemFragment = new ItemFragment();
        listFragment = new ListFragment();
        blankFragment = new BlankFragment();

        cur = blankFragment;

        FragmentUtils.add(fragmentMng, blankFragment, R.id.gridFragment);
        FragmentUtils.add(fragmentMng, listFragment, R.id.listFragment);

        findView(R.id.btnSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment dst = cur == blankFragment?itemFragment:blankFragment;
               FragmentUtils.replace(cur, dst, R.anim.slide_in_left, R.anim.slide_in_right) ;
               cur = dst;
            }
        });
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        FragmentUtils.replace(blankFragment, itemFragment, R.anim.slide_in_left, R.anim.slide_in_right) ;
    }
}
