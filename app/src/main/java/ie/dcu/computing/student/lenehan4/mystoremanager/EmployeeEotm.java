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

public class EmployeeEotm extends Fragment {

    private Button ViewWinner;
    private Button Vote;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.employee_eotm, container, false);

        ViewWinner = view.findViewById(R.id.btnViewWinner);
        Vote = view.findViewById(R.id.btnVote);

        ViewWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SecondActivity.class));
            }
        });

        Vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SecondActivity.class));
            }
        });

        return view;
    }
}
