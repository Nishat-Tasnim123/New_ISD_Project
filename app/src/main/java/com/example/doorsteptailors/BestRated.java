package com.example.doorsteptailors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestRated extends Fragment {

    private ListView listView;
    private String[] TailorNames;

    int[] images = {R.drawable.tailor1,R.drawable.tailor2,R.drawable.tailor3};
    public BestRated() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        TailorNames = getResources().getStringArray(R.array.tailor_name);
        //listView = listView.findViewById(R.id.BRlistviewID);

        //CustomAdapter adapter = new CustomAdapter(this.getContext(),TailorNames,images);
        //listView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_best_rated, container, false);


    }

}
