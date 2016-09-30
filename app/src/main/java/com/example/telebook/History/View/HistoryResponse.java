package com.example.telebook.History.View;

import java.util.List;

/**
 * Created by iket on 29/9/16.
 */
public class HistoryResponse {
    private List<HistoryData> historyDatas;

    public HistoryResponse(List<HistoryData> historyDatas) {
        this.historyDatas = historyDatas;
    }

    public List<HistoryData> getHistoryDatas() {
        return historyDatas;
    }
}
