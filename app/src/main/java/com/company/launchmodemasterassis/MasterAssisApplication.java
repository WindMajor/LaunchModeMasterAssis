package com.company.launchmodemasterassis;

import android.app.Application;

import com.company.launchmodemasterassis.data.ActivityStartManager;
import com.company.launchmodemasterassis.data.LaunchFlagManager;

/**
 * Created by wangmeng on 17/4/26.
 */

public class MasterAssisApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LaunchFlagManager.init();
        ActivityStartManager.init();
    }
}
