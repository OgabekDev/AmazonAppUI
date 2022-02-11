package dev.ogabek.amazonappui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.amazonappui.R;
import dev.ogabek.amazonappui.adapter.EssentialAdapter;
import dev.ogabek.amazonappui.model.Essential;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout fashion, popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_essential);
        fashion = findViewById(R.id.ll_fashion);
        popular = findViewById(R.id.ll_popular);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        refreshAdapter(getEssentials());

        setLinearHeight(fashion);
        setLinearHeight(popular);
    }

    private void setLinearHeight(LinearLayout layout) {
        //Get Screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;

        //Change pixel to dp
        int heightInDp = (int) (heightPixels / getResources().getDisplayMetrics().density);

        //Set layout with programmatically
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = heightInDp;
        layout.setLayoutParams(params);
    }

    private void refreshAdapter(List<Essential> essentials) {
        EssentialAdapter adapter = new EssentialAdapter(essentials);
        recyclerView.setAdapter(adapter);
    }

    private List<Essential> getEssentials() {
        List<Essential> essentials = new ArrayList<>();
        essentials.add(new Essential("Oculus", R.drawable.game));
        essentials.add(new Essential("Game", R.drawable.game));
        essentials.add(new Essential("Mobile", R.drawable.game));
        return essentials;
    }
}