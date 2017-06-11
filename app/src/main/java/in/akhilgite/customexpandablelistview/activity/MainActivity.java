package in.akhilgite.customexpandablelistview.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;

import in.akhilgite.customexpandablelistview.R;
import in.akhilgite.customexpandablelistview.adapters.ContainerAdapter;
import in.akhilgite.customexpandablelistview.model.Item;
import in.akhilgite.customexpandablelistview.model.Row;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> containerArrayList;
    ArrayList<Row> machineArrayList;
    ArrayList<Row> groupArrayList;
    RecyclerView rvContainer;
    ContainerAdapter adapter;

    /**
     * Initializing variables with the respective XML component
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContainer = (RecyclerView) findViewById(R.id.rv_container);
        rvContainer.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.category_divider,null));
        }else {
            dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.category_divider));
        }
        rvContainer.addItemDecoration(dividerItemDecoration);
    }

    /**
     * Loading the data to collection, initializing adapter class, attaching adapter to the recyclerView
     * when view gets loaded
     */
    @Override
    protected void onStart() {
        super.onStart();

        machineArrayList = new ArrayList<>();
        machineArrayList.add(new Row("MC 1", "INTEGREX Multitasking", "12:25", R.mipmap.ic_launcher));
        machineArrayList.add(new Row("MC 2", "Vertical Center Nexus", "12:15", R.mipmap.ic_launcher));
        machineArrayList.add(new Row("MC 3", "Vertical Center Nexus", "12.00", R.mipmap.ic_launcher));

        groupArrayList = new ArrayList<>();
        groupArrayList.add(new Row("GRP 1", "Shop Floor 1 Machiner", "12:20", R.mipmap.ic_launcher));
        groupArrayList.add(new Row("GRP 1", "Shop Floor 1 Machiner", "11:30", R.mipmap.ic_launcher));
        groupArrayList.add(new Row("GRP 1", "Shop Floor 1 Machiner", "11:00", R.mipmap.ic_launcher));

        containerArrayList = new ArrayList<>();
        containerArrayList.add(new Item("MACHINE", false, machineArrayList));
        containerArrayList.add(new Item("GROUP", false, groupArrayList));

        adapter = new ContainerAdapter(this, containerArrayList);
        rvContainer.setAdapter(adapter);
    }

}
