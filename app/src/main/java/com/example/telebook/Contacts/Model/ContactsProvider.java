package com.example.telebook.Contacts.Model;

import com.example.telebook.Contacts.view.OnContactsReceived;

/**
 * Created by iket on 27/9/16.
 */
public interface ContactsProvider {
    void requestContacts(OnContactsReceived onContactsReceived);
}
