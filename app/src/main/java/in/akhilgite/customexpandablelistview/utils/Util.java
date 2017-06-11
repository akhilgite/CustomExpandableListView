package in.akhilgite.customexpandablelistview.utils;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import in.akhilgite.customexpandablelistview.R;


/**
 * Created by akhil on 10/6/17.
 */

public class Util {
    public static DividerItemDecoration getDivider(Context context, String key){
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,LinearLayoutManager.VERTICAL);
        switch (key){
            case GTConstants.KEY_CATEGORY_DIVIDER:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.category_divider,null));
                    return dividerItemDecoration;
                }else {
                    dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.category_divider));
                    return dividerItemDecoration;
                }

            case GTConstants.KEY_ROW_DIVIDER:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.row_divider,null));
                    return dividerItemDecoration;
                }else {
                    dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.row_divider));
                    return dividerItemDecoration;
                }
        }
        return null;
    }
}
