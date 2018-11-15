package com.example.root.sectionedrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView cart;
    ArrayList<SectionModel> sectionList;
    //    ArrayList<Model> modelList;
    String str = "{\n" +
            "    \"menu\": [\n" +
            " {\n" +
            "            \"date\": \"12-10-18\",\n" +
            "            \"menu\": [\n" +
            "                {\n" +
            "                    \"abc\": \"abc\",\n" +
            "                    \"def\": \"ghi\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-illustration/beautiful-green-red-aurora-dancing-450w-1078896365.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"abc\": \"fd\",\n" +
            "                    \"def\": \"sda\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-vector/planet-night-sky-space-star-450w-450487273.jpg\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"12-10-18\",\n" +
            "            \"menu\": [\n" +
            "                {\n" +
            "                    \"abc\": \"abc\",\n" +
            "                    \"def\": \"ghi\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-illustration/beautiful-green-red-aurora-dancing-450w-1078896365.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"abc\": \"fd\",\n" +
            "                    \"def\": \"sda\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-vector/planet-night-sky-space-star-450w-450487273.jpg\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"11-10-18\",\n" +
            "            \"menu\": [\n" +
            "                {\n" +
            "                    \"abc\": \"abc\",\n" +
            "                    \"def\": \"ghi\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-illustration/planet-elements-this-image-furnished-450w-721389373.jpg\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"abc\": \"fd\",\n" +
            "                    \"def\": \"sda\",\n" +
            "                    \"img_url\": \"https://image.shutterstock.com/image-vector/black-hole-space-450w-683006953.jpg\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    JSONObject object;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.sectioned_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        cart=findViewById(R.id.cart);
        try {
            object = new JSONObject(str);

            JSONArray jsonArray = object.getJSONArray("menu");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject innerObject = jsonArray.getJSONObject(i); ////////object under main root
                String str;
                str = innerObject.getString("date");
                JSONArray innerMenuArray = innerObject.getJSONArray("menu");
                ArrayList<Model> modelList = new ArrayList<>();
                for (int j = 0; j < innerMenuArray.length(); j++) {
                    JSONObject obj = innerMenuArray.getJSONObject(j);
                    Model model = new Model();
                    model.setAbc(obj.getString("abc"));
                    model.setDef(obj.getString("def"));
                    model.setImg_url(obj.getString("img_url"));
                    modelList.add(model);
                }

                sectionList.add(new SectionModel(str, modelList));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HeaderAdapter adapter = new HeaderAdapter(sectionList, MainActivity.this);
        recyclerView.setAdapter(adapter);


    }
    public void getCount(int count){
        cart.setText(""+count);
    }

}
