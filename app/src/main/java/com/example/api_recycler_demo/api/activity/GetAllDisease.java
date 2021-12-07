package com.example.api_recycler_demo.api.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_recycler_demo.R;
import com.example.api_recycler_demo.api.APIClient;
import com.example.api_recycler_demo.api.APIInterface;
import com.example.api_recycler_demo.api.NoConnectivityException;
import com.example.api_recycler_demo.model.GetAllDisease_DiseaseModel;
import com.example.api_recycler_demo.model.GetAllDisease_RootModel;
import com.example.api_recycler_demo.model.ListTest_Model;
import com.example.api_recycler_demo.model.ListTest_RootModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllDisease extends AppCompatActivity {

    LinearLayout llProgressBar;
    RecyclerView alldisease_recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_disease);

        alldisease_recyclerView = findViewById(R.id.alldisease_recyclerView);
        llProgressBar = findViewById(R.id.llProgressBar);

        setToolbar();
        getAllDisease();
    }


    void getAllDisease() {

        APIClient
                .getClient(GetAllDisease.this)
                .create(APIInterface.class)
                .getDisease("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTg5ZWQ3ZjQ0MDhlNzQzOGI5MjFmZDVmODQ2MzEyNzBlMTZkMDk3OTcyY2ZlMTZlZjIyNGM2MjNhZjYyMjU3ZDQzYjMxMWQyNGRhMDg3M2UiLCJpYXQiOjE2MzA3MzEzNjYuMzM4MDQzLCJuYmYiOjE2MzA3MzEzNjYuMzM4MDUyLCJleHAiOjE2NjIyNjczNjYuMTc5MDA4LCJzdWIiOiIxIiwic2NvcGVzIjpbImZyb250X3VzZXIiXX0.FVozG3tEXGegsJGkG7o7f6rfN3AMXcbK4Odf1bM_V81kqX9G1mOBdYaE0jMhoS3BApeN7yJQJr8jOEZa4Wu_NTOpluMil59WUx-OPNu4AZ95YrBxHF2lIrD7YYKUwHAy-DxrAPRo_9B6Ghnnu43mqH0GHJhuTevXe0mmFDN5qrscw4G3WMgUqi-JC7o0IPeEx_qC_155KKjBEweP1RUSwqJeI0Fc0d7iqexi7l7spc7ex_wej-EMmqkLz5o_7rb8tsTAPtpnfhVIOEdmb_wVyx4LcNqHf4Z1g3S7zX_FfHJZz1EndPIWr75Oxah3qh4coyuBjaKWI2WNSt4XKuwlFHbeI1rPTRK-u39a4qT4C0Ppe0Mpncdv0J0p56UeNdNtChj87ZNCS0I-LkOiUClxLryzjTvpz-gDhSekBA5qe7FjP7T868Nem24ubvaVmLTi8uRA3GKv5_X3rniJUd4jSVFsCuX1gPidZ4dUvRsF48XJr07iPNPqZZ3ahSk6DTEu-8vfaH_jNrGuBrwcVfBEmHLawAfXvBCcomx9wXdbp8Pkadij6qmTPWZf7aWPWXsX9hEwRC64RNouRlKQxARHsni2HWwgbh6JUmGRkiG6ou4NmR6HjjNSp0lEmLhkPCA-hw91WW8ugPaLNYLMA3bEsEQPMHWnUqe_Yrm2jyljtuM")
                .enqueue(new Callback<GetAllDisease_RootModel>() {
                    @Override
                    public void onResponse(Call<GetAllDisease_RootModel> call, Response<GetAllDisease_RootModel> response) {
                        llProgressBar.setVisibility(View.GONE);
                        if (response.code() == 401) {
                        } else if (response.code() == 200) {
                            if (response.body() != null) {
                                GetAllDisease_RootModel apiResponse = response.body();

                                if (!apiResponse.getError()) {
                                    UserAdapter userAdapter = new UserAdapter(apiResponse.getDiseases());
                                    alldisease_recyclerView.setLayoutManager(new LinearLayoutManager(GetAllDisease.this));
                                    alldisease_recyclerView.setAdapter(userAdapter);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GetAllDisease_RootModel> call, Throwable t) {
                        llProgressBar.setVisibility(View.GONE);
                        Log.e("onFailure", t.toString() + "");
                        if (t instanceof NoConnectivityException) {
                            Toast.makeText(GetAllDisease.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        call.cancel();
                    }
                });
    }


    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
        private List<GetAllDisease_DiseaseModel> listdata;

        // RecyclerView recyclerView;
        public UserAdapter(List<GetAllDisease_DiseaseModel> listdata) {
            this.listdata = listdata;
        }

        @Override
        public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_getalldisease, parent, false);
            UserAdapter.ViewHolder viewHolder = new UserAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(
                UserAdapter.ViewHolder holder, int position) {
            final GetAllDisease_DiseaseModel myListData = listdata.get(position);

//            Log.e("url",APIClient.url + "risk_areas_images/" + myListData.getImage());
//
//            new GlideImageLoader(holder.img_view, holder.progress)
//                    .load(APIClient.url + "risk_areas_images/" + myListData.getImage(), Utility.getGlideRequestOptions());

            holder.text_view.setText(myListData.getName());

//            holder.img_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });


//            holder.img_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(HomeScreen.this, UpdateGenre.class);
//                    i.putExtra("isEdit", true);
//                    i.putExtra("genre",myListData);
//                    startActivity(i);
//                }
//            });


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "click on item: " + myListData.getName(), Toast.LENGTH_LONG).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            //  public ImageView img_view;
            public TextView text_view;
            ProgressBar progress;

            public ViewHolder(View itemView) {
                super(itemView);

                //      this.img_view = itemView.findViewById(R.id.img_view);
                this.text_view = itemView.findViewById(R.id.text_view);
                this.progress = itemView.findViewById(R.id.progress);
            }
        }
    }






    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Get All Disease");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}