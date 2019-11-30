package ng.com.obkm.bottomnavviewwithfragments.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ng.com.obkm.bottomnavviewwithfragments.R;
import ng.com.obkm.bottomnavviewwithfragments.adapter.FoodAdapter;


public class HomeFragment extends Fragment {

    private GridView gridView;
    private List<Food> listFood;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = (GridView) view.findViewById(R.id.GV);



        listFood = new ArrayList<>();
        listFood.add(new Food(1, "Lập Trình Java"));
        listFood.add(new Food(2, "Lập Trình Android"));
        listFood.add(new Food(3, "Lập Trình JavaFX"));
        listFood.add(new Food(4, "Lập Trình Web"));
        listFood.add(new Food(5, "Lập Trình Ruby"));
        listFood.add(new Food(6, "Lập Trình C++"));
        listFood.add(new Food(7, "Lập Trình PHP"));
        listFood.add(new Food(8, "Lập Trình WordPress"));

        FoodAdapter adapter = new FoodAdapter(this, R.layout.custom_menu, listFood);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long l) {
                Food food=listFood.get(id);
                Toast.makeText(getContext(), food.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
