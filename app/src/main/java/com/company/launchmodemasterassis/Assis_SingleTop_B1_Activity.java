package com.company.launchmodemasterassis;


import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by wangmeng on 17/4/26.
 */

public class Assis_SingleTop_B1_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.assis_single_top_b1_activity_title);
    }

}
