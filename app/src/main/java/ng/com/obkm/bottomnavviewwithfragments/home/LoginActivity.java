package ng.com.obkm.bottomnavviewwithfragments.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


import ng.com.obkm.bottomnavviewwithfragments.MainActivity;
import ng.com.obkm.bottomnavviewwithfragments.R;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout rellay1, rellay2;
    Button bt_login, bt_signup, bt_forgot;
    EditText et_user, et_pass;
    String user;
    String pass;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1=(RelativeLayout) findViewById(R.id.rellay1);
        rellay2=(RelativeLayout) findViewById(R.id.rellay2);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(activityChangeIntent);
            }
        });
        bt_signup = (Button) findViewById(R.id.bt_signup);
        bt_forgot = (Button) findViewById(R.id.bt_forgot);
        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        handler.postDelayed(runnable,5000);
    }
    public void exit(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Xác nhận");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.ifo);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Đóng Activity hiện tại
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"Bạn đã click vào nút không đồng ý", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        positiveButton.setTextColor(Color.parseColor("#FF0B8B42"));
        negativeButton.setTextColor(Color.parseColor("#FFFF0400"));

    }
}
