package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, busNumField;
    private Spinner provinceSpin, businessSpin;
    private Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        busNumField = (EditText) findViewById(R.id.businessNumber);
        addressField = (EditText) findViewById(R.id.address);
        provinceSpin = (Spinner) findViewById(R.id.province);
        businessSpin = (Spinner) findViewById(R.id.business);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busNumField.setText(receivedPersonInfo.businessNumber);
            addressField.setText(receivedPersonInfo.address);
            provinceSpin.setSelected(Boolean.parseBoolean(receivedPersonInfo.province));
            businessSpin.setSelected(Boolean.parseBoolean(receivedPersonInfo.business));
        }
    }

    public void updateContact(View v){
        String personID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String busNum = busNumField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceSpin.getSelectedItem().toString();
        String business = businessSpin.getSelectedItem().toString();

        Contact person = new Contact(personID, busNum, name, business, address, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void eraseContact(View v)
    {
        String personID = receivedPersonInfo.uid;
        appState.firebaseReference.child(personID).removeValue();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}