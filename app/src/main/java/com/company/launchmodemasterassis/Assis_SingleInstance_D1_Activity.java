package com.company.launchmodemasterassis;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by wangmeng on 17/4/26.
 */

public class Assis_SingleInstance_D1_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.assis_single_instance_d1_activity_title);
    }
}
