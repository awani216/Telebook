package com.example.telebook.Contacts.view;

import java.util.List;

/**
 * Created by Iket on 8/20/2016.
 */
public interface OnContactsReceived {
    void onFailure();
    void onSuccess(List<ContactsData> contactDataList);
}
