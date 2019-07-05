package com.example.fordlabs.viewpagerfrag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




public class MyFragment extends Fragment {

    public MyFragment() {
        // Required empty public constructor
    }



    public static MyFragment newInstance(String fragmentName) {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString("msg", fragmentName);
        f.setArguments(bdl);
        return f;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            String message = getArguments().getString("msg");
            View v = inflater.inflate(R.layout.fragment_my, container, false);
            TextView fragtext = (TextView)v.findViewById(R.id.fragText);
            fragtext.setText(message);
            return v;

        }
    }


