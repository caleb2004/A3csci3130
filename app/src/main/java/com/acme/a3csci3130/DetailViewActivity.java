package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, busNumField;
    private Spinner provSpin, priBusSpin;
    private MyApplicationData appState;
    private Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());


        busNumField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.Name);
        addressField = (EditText) findViewById(R.id.Address);
        provSpin = (Spinner) findViewById(R.id.province);
        priBusSpin = (Spinner) findViewById(R.id.primaryBusiness);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            busNumField.setText(receivedPersonInfo.businessNumber);
            priBusSpin.setSelected(Boolean.parseBoolean(receivedPersonInfo.primaryBusiness));
            addressField.setText(receivedPersonInfo.address);
            provSpin.setSelected(Boolean.parseBoolean(receivedPersonInfo.province));
        }
    }

    //update the contact and stored in the Firebase
    public void updateContact(View v){
        String personID = receivedPersonInfo.uid;
        String businessNumber = busNumField.getText().toString();
        String name = nameField.getText().toString();
        String primaryBusiness = priBusSpin.getSelectedItem().toString();
        String address = addressField.getText().toString();
        String province = provSpin.getSelectedItem().toString();

        Contact contact = new Contact(personID, businessNumber, name, primaryBusiness, address, province);

        appState.firebaseReference.child(personID).setValue(contact);

        finish();
    }

    //remove the contact that stored in the Firebase
    public void eraseContact(View v)
    {
        String personID = receivedPersonInfo.uid;
        appState.firebaseReference.child(personID).removeValue();

        finish();
    }
}
