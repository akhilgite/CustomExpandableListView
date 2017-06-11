package in.akhilgite.customexpandablelistview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ItemHolder> {
    private Context context;
    private ArrayList<Row> arrayList;
    private LayoutInflater inflater;

    public RowAdapter(Context context, ArrayList<Row> arrayList) {
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

        ImageView ivIcon=new ImageView(context);
        ivIcon.setMaxWidth(50);
        ivIcon.setMaxHeight(50);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(15, 15, 15, 15);
        ivIcon.setLayoutParams(lp);


        return new ItemHolder(rootView);
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

        public ItemHolder(View itemView) {
            super(itemView);
            tvHeader = (TextView) itemView.findViewById(R.id.tv_header);
            tvDetails = (TextView) itemView.findViewById(R.id.tv_details);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
