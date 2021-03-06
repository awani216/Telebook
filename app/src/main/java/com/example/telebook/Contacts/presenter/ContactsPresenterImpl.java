package com.example.telebook.Contacts.presenter;

import android.util.Log;

import com.example.telebook.Contacts.Model.ContactsProvider;
import com.example.telebook.Contacts.view.ContactsData;
import com.example.telebook.Contacts.view.ContactsInterface;
import com.example.telebook.Contacts.view.OnContactsReceived;

import java.util.List;



/**
 * Created by Iket on 8/20/2016.
 */
public class ContactsPresenterImpl implements ContactsPresenter {
    private ContactsProvider contactsProvider;
    private ContactsInterface contactsInterface;

    public ContactsPresenterImpl(ContactsInterface contactsInterface, ContactsProvider contactsProvider) {
        this.contactsInterface = contactsInterface;
        this.contactsProvider = contactsProvider;

    }

    @Override
    public void requestContacts() {
        contactsInterface.ShowProgressBar(true);
        contactsProvider.requestContacts(new OnContactsReceived() {

            @Override
            public void onFailure() {
                contactsInterface.ShowProgressBar(false);
                Log.d("ResponseOtp","Fail");
            }

            @Override
            public void onSuccess(List<ContactsData> contactDataList) {

                Log.d("ResponseOtp","Success");
                contactsInterface.SetData(contactDataList);
                contactsInterface.ShowProgressBar(false);

            }
        });
    }
}
