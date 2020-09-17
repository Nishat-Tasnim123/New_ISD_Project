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
public class Received_orders extends Fragment {
    private ListView listView;
    private String[] Item1;
    View view;


    public Received_orders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_received_orders, container, false);
        Item1 = getResources().getStringArray(R.array.item1);
        listView = (ListView) view.findViewById(R.id.ROlistviewID);
        CustomAdapter1 adapter1=new CustomAdapter1(this.getContext(),Item1);
        listView.setAdapter(adapter1);
        return view;
    }

}
