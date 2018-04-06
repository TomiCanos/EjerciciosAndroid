package com.example.dh.loginregisterfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        Bundle bundle = getArguments();
        TextView textView = view.findViewById(R.id.fragment_welcome_txtview);
        String username = bundle.getString("CLAVE_USERNAME");
        String password = bundle.getString("CLAVE_PASSWORD");
        textView.setText("welcome " + username + " " + password + "!");
        return view;
    }

}
