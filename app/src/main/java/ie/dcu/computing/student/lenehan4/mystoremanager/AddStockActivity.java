package ie.dcu.computing.student.lenehan4.mystoremanager;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStockActivity extends AppCompatActivity {

    private EditText UPC, Brand, Description, Quantity, Price;
    private Button AddItem, View;
    StockDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        myDb = new StockDatabase(this);

        UPC = findViewById(R.id.etUpc);
        Brand = findViewById(R.id.etBrand);
        Description = findViewById(R.id.etDescription);
        Quantity = findViewById(R.id.etQuantity);
        Price = findViewById(R.id.etPrice);
        AddItem = findViewById(R.id.btnAddItem);
        View = findViewById(R.id.btnView);


        AddItem();
        viewStock();


    }

    public void AddItem(){
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(UPC.getText().toString(), Brand.getText().toString(), Description.getText().toString(), Quantity.getText().toString(), Price.getText().toString());
                if (isInserted == true){
                    Toast.makeText(AddStockActivity.this, "Item is inserted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddStockActivity.this, "Oops", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewStock(){
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0){
                    //show message
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("UPC : "+ res.getString(0)+"\n");
                    buffer.append("Brand : "+ res.getString(1)+"\n");
                    buffer.append("Description : "+ res.getString(2)+"\n");
                    buffer.append("Quantity : "+ res.getString(3)+"\n");
                    buffer.append("Price : "+ res.getString(4)+"\n\n");
                }
                //Show all data
                showMessage("My Stock", buffer.toString());
            }
        });
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==4){
            String message = data.getStringExtra("Result");
            UPC.setText(message);
        }
    }


}
