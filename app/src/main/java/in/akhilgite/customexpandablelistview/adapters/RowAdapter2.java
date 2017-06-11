package in.akhilgite.customexpandablelistview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

import in.akhilgite.customexpandablelistview.R;
import in.akhilgite.customexpandablelistview.model.Row;

/**
 * Created by akhil on 10/6/17.
 */

public class RowAdapter2 extends RecyclerView.Adapter<RowAdapter2.ItemHolder> {
    private Context context;
    private ArrayList<Row> arrayList;
    private LayoutInflater inflater;

    public RowAdapter2(Context context, ArrayList<Row> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.item_row2, parent, false);

        LinearLayout conainer=new LinearLayout(context);
        conainer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        conainer.setOrientation(LinearLayout.HORIZONTAL);

        return new ItemHolder(conainer);
    }

    /**
     * Binding data with holder variables
     */
    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Row row = arrayList.get(position);
        holder.tvHeader.setText(row.getHeader());
        holder.tvDetails.setText(row.getDeatils());
        holder.tvTime.setText(row.getTime());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        TextView tvDetails;
        TextView tvTime;
        LinearLayout layout;

        public ItemHolder(View itemView) {
            super(itemView);

            layout= (LinearLayout) itemView;

            ImageView ivIcon=new ImageView(context);
            ivIcon.setMaxWidth(50);
            ivIcon.setMaxHeight(50);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(15, 15, 15, 15);
            ivIcon.setLayoutParams(lp);
            ivIcon.setImageResource(R.mipmap.ic_launcher_round);

            tvHeader=new TextView(context);
            tvHeader.setGravity(Gravity.CENTER_VERTICAL);
            tvHeader.setMaxWidth(0);
            tvHeader.setTextSize(18);
            tvHeader.setGravity(Gravity.CENTER_VERTICAL);
            tvHeader.setTextColor(context.getResources().getColor(R.color.textColor));
            tvHeader.setMaxHeight(80);

            LinearLayout.LayoutParams headerParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            headerParams.setMargins(15,15,100,15);
            headerParams.weight=1;
            headerParams.gravity=Gravity.CENTER_VERTICAL;
            tvHeader.setLayoutParams(headerParams);


            tvDetails=new TextView(context);
            tvDetails.setTextColor(context.getResources().getColor(R.color.textColor));


            tvTime=new TextView(context);
            tvTime.setTextColor(context.getResources().getColor(R.color.textColor));
            tvTime.setGravity(Gravity.END);
            //tvTime.setLayoutParams(timeParams);

            LinearLayout subLayout=new LinearLayout(context);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity=Gravity.CENTER_VERTICAL;
            params.setMargins(0,15,15,15);
            subLayout.setLayoutParams(params);
            subLayout.setOrientation(LinearLayout.VERTICAL);

            //subLayout.setMinimumHeight(80);
            subLayout.addView(tvTime);
            subLayout.addView(tvDetails);

            layout.addView(ivIcon);
            layout.addView(tvHeader);
            layout.addView(subLayout);
        }
    }


}
