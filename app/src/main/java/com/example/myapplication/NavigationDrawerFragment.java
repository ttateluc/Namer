package com.example.myapplication;



import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavigationDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */



public class NavigationDrawerFragment extends BottomSheetDialogFragment {

    static String line;
    TextView tv_text2;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    InputStream is = null;
    Context context;
    static String stateName = "Arizona";

    public NavigationDrawerFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavigationDrawerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NavigationDrawerFragment newInstance(String param1, String param2) {
        NavigationDrawerFragment fragment = new NavigationDrawerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public NavigationDrawerFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tv_text2 = MainActivity.tv_text2;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);


        NavigationView navigationView =  view.findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id)

                {
                    case R.id.Alabama:
                        stateName = "Alabama";
                        tv_text2.setText("Selected: Alabama");

                        break;
                    case R.id.Alaska:
                        stateName = "Alaska";
                        tv_text2.setText("Selected: Alaska");
                        break;
                    case R.id.Arizona:
                        stateName = "Arizona";
                        tv_text2.setText("Selected: Arizona");
                        break;
                    case R.id.Arkansas:
                        stateName = "Arkansas";
                        tv_text2.setText("Selected: Arkansas");
                        break;
                    case R.id.California:
                        stateName = "California";
                        tv_text2.setText("Selected: California");
                        break;
                    case R.id.Colorado:
                        stateName = "Colorado";
                        tv_text2.setText("Selected: Colorado");
                        break;
                    case R.id.Connecticut:
                        stateName = "Connecticut";
                        tv_text2.setText("Selected: Connecticut");
                        break;
                    case R.id.Delaware:
                        stateName = "Delaware";
                        tv_text2.setText("Selected: Delaware");
                        break;
                    case R.id.Florida:
                        stateName = "Florida";
                        tv_text2.setText("Selected: Florida");
                        break;
                    case R.id.Georgia:
                        stateName = "Georgia";
                        tv_text2.setText("Selected: Georgia");
                        break;
                    case R.id.Hawaii:
                        stateName = "Hawaii";
                        tv_text2.setText("Selected: Hawaii");
                        break;
                    case R.id.Idaho:
                        stateName = "Idaho";
                        tv_text2.setText("Selected: Idaho");
                        break;
                    case R.id.Illinois:
                        stateName = "Illinois";
                        tv_text2.setText("Selected: Illinois");
                        break;
                    case R.id.Indiana:
                        stateName = "Indiana";
                        tv_text2.setText("Selected: Indiana");
                        break;
                    case R.id.Iowa:
                        stateName = "Iowa";
                        tv_text2.setText("Selected: Iowa");
                        break;
                    case R.id.Kansas:
                        stateName = "Kansas";
                        tv_text2.setText("Selected: Kansas");
                        break;
                    case R.id.Kentucky:
                        stateName = "Kentucky";
                        tv_text2.setText("Selected: Kentucky");
                        break;
                    case R.id.Louisiana:
                        stateName = "Louisiana";
                        tv_text2.setText("Selected: Louisiana");
                        break;
                    case R.id.Maine:
                        stateName = "Maine";
                        tv_text2.setText("Selected: Maine");
                        break;
                    case R.id.Maryland:
                        stateName = "Maryland";
                        tv_text2.setText("Selected: Maryland");
                        break;
                    case R.id.Massachusetts:
                        stateName = "Massachusetts";
                        tv_text2.setText("Selected: Massachusetts");
                        break;
                    case R.id.Michigan:
                        stateName = "Michigan";
                        tv_text2.setText("Selected: Michigan");
                        break;
                    case R.id.Minnesota:
                        stateName = "Minnesota";
                        tv_text2.setText("Selected: Minnesota");
                        break;
                    case R.id.Mississippi:
                        stateName = "Mississippi";
                        tv_text2.setText("Selected: Mississippi");
                        break;
                    case R.id.Missouri:
                        stateName = "Missouri";
                        tv_text2.setText("Selected: Missouri");
                        break;
                    case R.id.Montana:
                        stateName = "Montana";
                        tv_text2.setText("Selected: Montana");
                        break;
                    case R.id.Nebraska:
                        stateName = "Nebraska";
                        tv_text2.setText("Selected: Nebraska");
                        break;
                    case R.id.Nevada:
                        stateName = "Nevada";
                        tv_text2.setText("Selected: Nevada");
                        break;
                    case R.id.New_Hampshire:
                    stateName = "New Hampshire";
                        tv_text2.setText("Selected: New Hampshire");
                        break;
                    case R.id.New_Jersey:
                    stateName = "New Jersey";
                        tv_text2.setText("Selected: New Jersey");
                        break;
                    case R.id.New_Mexico:
                    stateName = "New Mexico";
                        tv_text2.setText("Selected: New Mexico");
                        break;
                    case R.id.New_York:
                    stateName = "New York";
                        tv_text2.setText("Selected: New York");
                        break;
                    case R.id.North_Carolina:
                    stateName = "North Carolina";
                        tv_text2.setText("Selected: North Carolina");
                        break;
                    case R.id.North_Dakota:
                    stateName = "North Dakota";
                        tv_text2.setText("Selected: North Dakota");
                        break;
                    case R.id.Ohio:
                        stateName = "Ohio";
                        tv_text2.setText("Selected: Ohio");
                        break;
                    case R.id.Oklahoma:
                        stateName = "Oklahoma";
                        tv_text2.setText("Selected: Oklahoma");
                        break;
                    case R.id.Oregon:
                        stateName = "Oregon";
                        tv_text2.setText("Selected: Oregon");
                        break;
                    case R.id.Pennsylvania:
                        stateName = "Pennsylvania";
                        tv_text2.setText("Selected: Pennsylvania");
                        break;
                    case R.id.Rhode_Island:
                    stateName = "Rhode Island";
                        tv_text2.setText("Selected: Rhode Island");
                        break;
                    case R.id.South_Carolina:
                    stateName = "South Carolina";
                        tv_text2.setText("Selected: South Carolina");
                        break;
                    case R.id.South_Dakota:
                    stateName = "South Dakota";
                        tv_text2.setText("Selected: South Dakota");
                        break;
                    case R.id.Tennessee:
                        stateName = "Tennessee";
                        tv_text2.setText("Selected: Tennessee");
                        break;
                    case R.id.Texas:
                        stateName = "Texas";
                        tv_text2.setText("Selected: Texas");
                        break;
                    case R.id.Utah:
                        stateName = "Utah";
                        tv_text2.setText("Selected: Utah");
                        break;
                    case R.id.Vermont:
                        stateName = "Vermont";
                        tv_text2.setText("Selected: Vermont");
                        break;
                    case R.id.Virginia:
                        stateName = "Virginia";
                        tv_text2.setText("Selected: Virginia");
                        break;
                    case R.id.Washington:
                        stateName = "Washington";
                        tv_text2.setText("Selected: Washington");
                        break;
                    case R.id.West_Virginia:
                    stateName = "West_Virginia";
                        tv_text2.setText("Selected: West Virginia");
                        break;
                    case R.id.Wisconsin:
                        stateName = "Wisconsin";
                        tv_text2.setText("Selected: Wisconsin");
                        break;
                    case R.id.Wyoming:
                        stateName = "Wyoming";
                        tv_text2.setText("Selected: Wyoming");
                        break;
                }

                return true;

            }




        });


        return view;

    }
}