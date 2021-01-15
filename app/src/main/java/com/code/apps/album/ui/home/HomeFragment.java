package com.code.apps.album.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.code.apps.album.R;
import com.code.apps.album.StaggeredRA;
import com.code.apps.album.row;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView cv;
    private TextView tv_title,tv_descrip;
    private LinearLayout linaer_scr;

    private RecyclerView satggeredRv;
    private StaggeredRA adapter;
    private StaggeredGridLayoutManager manager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //stagered

        satggeredRv=root.findViewById(R.id.stagered_rv);
        manager =new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        satggeredRv.setLayoutManager(manager);
        //array

        List<row> lst= new ArrayList<>();
        lst.add(new row(R.drawable.uno));
        lst.add(new row(R.drawable.dos));
        lst.add(new row(R.drawable.tres));
        lst.add(new row(R.drawable.cuatro));
        lst.add(new row(R.drawable.cinco));
        lst.add(new row(R.drawable.seis));
        lst.add(new row(R.drawable.uno));
        lst.add(new row(R.drawable.dos));
        lst.add(new row(R.drawable.tres));
        lst.add(new row(R.drawable.cuatro));
        lst.add(new row(R.drawable.cinco));
        lst.add(new row(R.drawable.seis));

        lst.add(new row(R.drawable.uno));
        lst.add(new row(R.drawable.dos));
        lst.add(new row(R.drawable.tres));
        lst.add(new row(R.drawable.cuatro));
        lst.add(new row(R.drawable.cinco));
        lst.add(new row(R.drawable.seis));
        lst.add(new row(R.drawable.uno));
        lst.add(new row(R.drawable.dos));
        lst.add(new row(R.drawable.tres));
        lst.add(new row(R.drawable.cuatro));
        lst.add(new row(R.drawable.cinco));
        lst.add(new row(R.drawable.seis));



        adapter=new StaggeredRA(getContext(),lst);
        satggeredRv.setAdapter(adapter);





        return root;
    }





}