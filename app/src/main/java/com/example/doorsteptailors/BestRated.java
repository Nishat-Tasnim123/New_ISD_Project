package com.example.doorsteptailors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestRated extends Fragment {

    private ListView listView;
    private String[] TailorNames;
    View view;

    int[] images = {R.drawable.tailor1,R.drawable.tailor2,R.drawable.tailor3};
    public BestRated() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_best_rated, container, false);
        TailorNames = getResources().getStringArray(R.array.tailor_name);
        //TextView textView = (TextView) view.findViewById(R.id.BestRatedtxtId);
        listView = (ListView) view.findViewById(R.id.BRlistviewID);

        CustomAdapter adapter = new CustomAdapter(this.getContext(),TailorNames,images);
        listView.setAdapter(adapter);
        return view;

    }



}
