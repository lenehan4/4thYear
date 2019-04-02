package ie.dcu.computing.student.lenehan4.mystoremanager;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ManagerStock extends Fragment {
    StockDatabase myDb;
    public Button ViewStock;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manager_stock, container, false);

        myDb = new StockDatabase(getActivity());


        ViewStock = view.findViewById(R.id.btnViewStock);

        viewStock();


        return view;
    }



    public void viewStock(){
        ViewStock.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append("€ : "+ res.getString(4)+"\n\n");
                }
                //Show all data
                showMessage("My Stock", buffer.toString());
                }
        });
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}
