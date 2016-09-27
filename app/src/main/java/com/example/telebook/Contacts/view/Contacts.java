package com.example.telebook.Contacts.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telebook.Contacts.Model.RetrofitRequestProvider;
import com.example.telebook.Contacts.presenter.ContactsPresenter;
import com.example.telebook.Contacts.presenter.ContactsPresenterImpl;
import com.example.telebook.R;

import java.util.List;


/**
 * Created by Iket on 8/20/2016.
 */
public class Contacts extends AppCompatActivity implements ContactsInterface {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ContactsPresenter contactsPresenter;
    private Toolbar toolbar;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("Response","1");
        setContentView(R.layout.activity_contact_us);

        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        toolbar.setTitle("Contacts");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.contactus_recycler1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        contactsPresenter = new ContactsPresenterImpl(this, new RetrofitRequestProvider());
        adapter = new Adapter(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        contactsPresenter.requestContacts();
    }

    @Override
    public void ShowProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void SetData(List<ContactsData> contactDataList) {
        adapter.setData(contactDataList);
        adapter.notifyDataSetChanged();
    }
}
