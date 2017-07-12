package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;


public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, addressField, busNumField;
    private MyApplicationData appState;
    private Spinner provSpin, priBusSpin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.Name);
        busNumField = (EditText) findViewById(R.id.businessNumber);
        addressField = (EditText) findViewById(R.id.Address);
        provSpin = (Spinner) findViewById(R.id.province);
        priBusSpin = (Spinner) findViewById(R.id.primaryBusiness);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String busNum = busNumField.getText().toString();
        String address = addressField.getText().toString();
        String province = provSpin.getSelectedItem().toString();
        String primaryBusiness = priBusSpin.getSelectedItem().toString();

        Contact contact = new Contact(personID, busNum, name, primaryBusiness, address, province);

        appState.firebaseReference.child(personID).setValue(contact);

        finish();

    }
}