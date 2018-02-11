package bill.edu.excise;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Bill on 2018/2/11.
 */

public class MedalAdapter extends BaseQuickAdapter<MedalItem, BaseViewHolder> {
    public MedalAdapter(int layoutResId, @Nullable List<MedalItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MedalItem item) {

        SimpleDraweeView view = helper.getView(R.id.mdl_wall_item_image);
        view.setImageResource(item.getIdIcon());

        helper.setText(R.id.mdl_wall_item_mdlname, item.getName());
        helper.setGone(R.id.mdl_wall_progressbar, true);
        helper.setGone(R.id.mdl_wall_item_got_textview, false);
        helper.setText(R.id.mdl_wall_item_got_textview, item.getGot());

    }
}
