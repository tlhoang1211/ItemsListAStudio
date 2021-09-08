package com.example.callapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.callapi.adapter.NewsAdapter;
import com.example.callapi.model.Item;
import com.example.callapi.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsActivity extends AppCompatActivity {

    public Item mItem;

    private final ArrayList<Item> listNew = new ArrayList<Item>();

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        getDataList();

        NewsAdapter adapter = new NewsAdapter(this, listNew);

        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);

        rv.addOnItemTouchListener(
                new RecyclerClickListener(this, new RecyclerClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );

//        mItem = Item.getItem(getIntent().getIntExtra("ID", 0));
    }

    private void getDataList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {

            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> itemList = response.body();
                assert itemList != null;
                String[] newTitle = new String[itemList.size()];
//                String[] newTitle = new String[itemList.size()];
//                String[] newTitle = new String[itemList.size()];

                for (int i = 0; i < itemList.size(); i++) {
                    newTitle[i] = itemList.get(i).getTitle();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(ListNewsActivity.this, "An error has occurred", Toast.LENGTH_LONG).show();
            }
        });
    }
}
