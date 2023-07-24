package com.example.splitbill;

import android.graphics.Typeface;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class EqualFragment extends Fragment {

    View view;

    TextView tv_equalText, tv_equalAmount, tv_recipient, tv_amount, tv_person;
    Button button_minus, button_plus, split_bill;
    EditText person_Field, amount_Field;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_equal, container, false);

        Typeface SFPRO = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/SFPRO.ttf");
        Typeface SFBOLD = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/SFPRO-Bold.ttf");

        tv_equalText = view.findViewById(R.id.tv_equalText);
        tv_equalAmount = view.findViewById(R.id.tv_equalAmount);
        tv_recipient = view.findViewById(R.id.tv_recipient);
        tv_amount = view.findViewById(R.id.tv_amount);
        tv_person = view.findViewById(R.id.tv_person);
        button_minus = view.findViewById(R.id.button_minus);
        button_plus = view.findViewById(R.id.button_plus);
        person_Field = view.findViewById(R.id.edit_1);
        amount_Field = view.findViewById(R.id.edit_2);
        split_bill = view.findViewById(R.id.split_bill);

        tv_equalText.setTypeface(SFPRO);
        tv_equalAmount.setTypeface(SFPRO);
        tv_recipient.setTypeface(SFPRO);
        tv_amount.setTypeface(SFPRO);
        tv_person.setTypeface(SFPRO);
        button_minus.setTypeface(SFPRO);
        button_plus.setTypeface(SFPRO);
        person_Field.setTypeface(SFPRO);
        amount_Field.setTypeface(SFPRO);
        split_bill.setTypeface(SFPRO);

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = Integer.parseInt(person_Field.getText().toString());
                person_Field.setText(String.valueOf(t+1));
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = Integer.parseInt(person_Field.getText().toString());
                if (t > 0){
                    person_Field.setText(String.valueOf(t-1));
                } else return;
            }
        });

        //equal calculation
        split_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int person_num = Integer.parseInt(person_Field.getText().toString());
                float amountRM = Float.parseFloat(amount_Field.getText().toString());
                float finalAmount = amountRM / person_num;
                String result = "RM " + String.format("%.2f", finalAmount);
                tv_equalAmount.setText(result);
            }
        });
        return view;
    }
}