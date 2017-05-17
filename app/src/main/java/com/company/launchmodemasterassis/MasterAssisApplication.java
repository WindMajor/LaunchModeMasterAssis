package com.company.launchmodemasterassis;

import android.app.Application;
import android.content.Context;

import com.company.launchmodemasterassis.data.ActivityStartManager;
import com.company.launchmodemasterassis.data.LaunchFlagManager;

/**
 * Created by wangmeng on 17/4/26.
 */

public class MasterAssisApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LaunchFlagManager.init();
        ActivityStartManager.init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = base;
    }


}
