package ie.dcu.computing.student.lenehan4.mystoremanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private Button managermode;
    private Button employeeMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        firebaseAuth = FirebaseAuth.getInstance();


        managermode = (Button)findViewById(R.id.btnManagerMode);
        employeeMode = (Button)findViewById(R.id.btnEmployeeMode);



        managermode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Managermode();
            }
        });


        employeeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employeemode();
            }
        });
    }




    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, LoginActivity.class));
    }


    private void Managermode(){
        startActivity(new Intent(SecondActivity.this, ManagerDrawerActivity.class));
    }

    private void Employeemode(){
        startActivity(new Intent(SecondActivity.this, AddStockActivity.class));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
