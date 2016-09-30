package com.example.telebook.History.View;

/**
 * Created by iket on 25/9/16.
 */
public interface HistoryInterface {
    void showLoading(boolean visible);
    void showMessage(String msg);
    void onGetData(HistoryData historyData);
}
