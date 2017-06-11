package in.akhilgite.customexpandablelistview.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.akhilgite.customexpandablelistview.R;
import in.akhilgite.customexpandablelistview.model.Item;
import in.akhilgite.customexpandablelistview.utils.Animator;

/**
 * Created by akhil on 10/6/17.
 */

public class ContainerAdapter extends RecyclerView.Adapter<ContainerAdapter.ItemHolder> {
    private ArrayList<Item> arrayList;
    private Context context;
    private LayoutInflater inflater;

    public ContainerAdapter(Context context, ArrayList<Item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.item_list, parent, false);
        return new ItemHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Item item = arrayList.get(position);
        holder.tvCategory.setText(item.getCategory());

        //if the item.isExpanded() == true then show item's recyclerView to the user
        //else hide it from the user
        //also show the respective icons of dropDownImageView
        if (item.isExpanded()) {
            holder.ivDropDown.setImageResource(R.drawable.ic_arrow_drop_up_white_24dp);
            //holder.rvRow.setVisibility(View.VISIBLE);
            //expandOrCollapse(holder.rlSubItemContainer,holder.rvRow,"expand");
        } else {
            holder.ivDropDown.setImageResource(R.drawable.ic_arrow_drop_down_white_24dp);
            //holder.rvRow.setVisibility(View.GONE);
            //expandOrCollapse(holder.rlSubItemContainer,holder.rvRow,"collapse");
        }

        RowAdapter2 adapter = new RowAdapter2(context, item.getArrayList());
        holder.rvRow.setLayoutManager(new LinearLayoutManager(context));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,LinearLayoutManager.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.row_divider,null));
        }else {
            dividerItemDecoration.setDrawable(context.getResources().getDrawable(R.drawable.row_divider));
        }
        holder.rvRow.addItemDecoration(dividerItemDecoration);
        holder.rvRow.setAdapter(adapter);
        holder.rvRow.setTag(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * holder class for holding row of this container
     */
    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCategory;
        ImageView ivDropDown;
        RelativeLayout rlSubItemContainer;
        RecyclerView rvRow;

        public ItemHolder(View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            ivDropDown = (ImageView) itemView.findViewById(R.id.iv_drop_down);
            rlSubItemContainer = (RelativeLayout) itemView.findViewById(R.id.rl_sub_item_container);
            rvRow = (RecyclerView) itemView.findViewById(R.id.rv_row);
            rlSubItemContainer.setOnClickListener((View.OnClickListener) this);
        }

        /**
         * OnClickListener of category layout
         */
        @Override
        public void onClick(View v) {
            //if user clicked on dropDownIcon and the item's recyclerView is expanded then hide it.
            //else show it
            //also change the respective icons of dropDownImageView
            Item item = arrayList.get(getAdapterPosition());
            if (item.isExpanded()) {
                //rvRow.setVisibility(View.GONE);
                Animator.collapse(rvRow,400,0);
                item.setExpanded(false);
            } else {
                //rvRow.setVisibility(View.VISIBLE);
                Animator.expand(rvRow,400,500);
                item.setExpanded(true);
            }
            notifyDataSetChanged();
        }
    }
}
