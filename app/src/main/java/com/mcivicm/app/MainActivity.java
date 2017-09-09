package com.mcivicm.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcivicm.easydecoration.BaseDecoration;
import com.mcivicm.easydecoration.HorizontalDecoration;
import com.mcivicm.easydecoration.ItemBorder;
import com.mcivicm.easydecoration.VerticalDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;//母recyclerView
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayout = (LinearLayout) findViewById(R.id.splitter);
        final Adapter adapter = new Adapter();
        recyclerView.addItemDecoration(new HorizontalDecoration()
                .setSize(getResources().getDimension(R.dimen.group_padding_left))
                .setColor(getResources().getColor(R.color.page_background_color))
                .setPaddingRight(0f)
                .setPaddingLeft(0f));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.addData(new ArbitraryItem());
        adapter.addData(new HorizontalItem());
        adapter.addData(new VerticalItem());
        adapter.notifyDataSetChanged();
    }


    private class Item {

    }

    private class ArbitraryItem extends Item {

    }

    private class HorizontalItem extends Item {

    }

    private class VerticalItem extends Item {

    }

    private class Adapter extends BaseQuickAdapter<Item, BaseViewHolder> {

        Adapter() {
            super(R.layout.item_object, new ArrayList<Item>());
        }

        private class ChildItem {
            int color;
        }

        private class ChildAdapter extends BaseQuickAdapter<ChildItem, BaseViewHolder> {

            ChildAdapter() {
                super(R.layout.item_child_object, new ArrayList<ChildItem>());
            }

            @Override
            protected void convert(BaseViewHolder helper, ChildItem item) {
                helper.setBackgroundColor(R.id.item_child, item.color);
            }
        }

        @Override
        protected void convert(BaseViewHolder helper, final Item item) {
            RecyclerView recyclerView = (RecyclerView) helper.itemView.findViewById(R.id.item_recycler);
            recyclerView.setNestedScrollingEnabled(false);
            ChildAdapter childAdapter = new ChildAdapter();
            recyclerView.setAdapter(childAdapter);
            int color = getResources().getColor(R.color.colorAccent);
            if (item instanceof ArbitraryItem) {
                recyclerView.addItemDecoration(new BaseDecoration() {
                    @Override
                    public void getItemBorder(int position, ItemBorder itemBorder, int count) {
                        itemBorder.setAllThickness(getResources().getDimension(R.dimen.normal_decoration_size))
                                .setColor(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)
                                .setAllPaddingLeft(getResources().getDimension(R.dimen.group_padding_left))
                                .setAllPaddingRight(getResources().getDimension(R.dimen.group_padding_right));
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            } else if (item instanceof HorizontalItem) {
                color = Color.WHITE;
                recyclerView.setBackgroundColor(Color.WHITE);
                recyclerView.addItemDecoration(new HorizontalDecoration()
                        .setPaddingLeft(getResources().getDimension(R.dimen.group_padding_left))
                        .setPaddingRight(0)
                        .setColor(getResources().getColor(R.color.group_splitter_color))
                        .setSize(getResources().getDimension(R.dimen.group_splitter_size)));
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            } else if (item instanceof VerticalItem) {
                recyclerView.addItemDecoration(new VerticalDecoration()
                        .setColor(getResources().getColor(R.color.group_splitter_color))
                        .setSize(getResources().getDimension(R.dimen.normal_decoration_size))
                        .setPaddingLeft(0)
                        .setPaddingRight(0));
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            }

            for (int i = 0; i < 10; i++) {
                ChildItem childItem = new ChildItem();
                childItem.color = color;
                childAdapter.addData(childItem);
            }
        }
    }

}
