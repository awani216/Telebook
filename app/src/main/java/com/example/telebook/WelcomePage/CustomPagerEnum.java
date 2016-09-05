package com.example.telebook.WelcomePage;

import com.example.telebook.R;

public enum CustomPagerEnum {

    RED(R.string.red, R.layout.sanskriti),
    BLUE(R.string.blue, R.layout.ecell),
    ORANGE(R.string.orange, R.layout.technocracy);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
