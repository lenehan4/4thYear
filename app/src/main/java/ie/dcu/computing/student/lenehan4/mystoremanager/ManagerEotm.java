package ie.dcu.computing.student.lenehan4.mystoremanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ManagerEotm extends Fragment {

    private Button UploadResult;
    private Button CreatePoll;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.manager_eotm, container, false);


        UploadResult = view.findViewById(R.id.btnUploadResult);
        CreatePoll = view.findViewById(R.id.btnCreatePoll);

        UploadResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SecondActivity.class));
            }
        });

        CreatePoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddStockActivity.class));
            }
        });
        return view;

    }

}
