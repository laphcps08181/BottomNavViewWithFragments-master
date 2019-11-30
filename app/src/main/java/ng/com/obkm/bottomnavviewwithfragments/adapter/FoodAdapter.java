package ng.com.obkm.bottomnavviewwithfragments.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ng.com.obkm.bottomnavviewwithfragments.R;
import ng.com.obkm.bottomnavviewwithfragments.home.Food;
import ng.com.obkm.bottomnavviewwithfragments.home.HomeFragment;

public class FoodAdapter extends BaseAdapter {
    private HomeFragment context;
    private int idLayout;
    private List<Food> listFood;
    private int positionSelect = -1;

    public FoodAdapter(HomeFragment context, int idLayout, List<Food> listFood) {
        this.context = context;
        this.idLayout = idLayout;
        this.listFood = listFood;
    }

    @Override
    public int getCount() {
        if (listFood.size() != 0 && !listFood.isEmpty()) {
            return listFood.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvFoodName = (TextView) convertView.findViewById(R.id.tv_foodname);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Food food = listFood.get(position);

        if (listFood != null && !listFood.isEmpty()) {
            tvFoodName.setText(food.getName());
            int idLanguage = food.getId();
            switch (idLanguage) {
                case 1:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.logopng);
                    break;
                default:
                    break;
            }
        }


        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}