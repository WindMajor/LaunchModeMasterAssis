package com.company.launchmodemasterassis.data;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;


import com.company.launchmodemasterassis.Assis_SingleInstance_D1_Activity;
import com.company.launchmodemasterassis.Assis_SingleInstance_D2_Activity;
import com.company.launchmodemasterassis.Assis_SingleTask_C1_Activity;
import com.company.launchmodemasterassis.Assis_SingleTask_C2_Activity;
import com.company.launchmodemasterassis.Assis_SingleTop_B1_Activity;
import com.company.launchmodemasterassis.Assis_SingleTop_B2_Activity;
import com.company.launchmodemasterassis.Assis_Standard_A1_Activity;
import com.company.launchmodemasterassis.AssisConstants;
import com.company.launchmodemasterassis.Assis_Standard_A2_Activity;
import com.company.launchmodemasterassis.MasterAssisApplication;
import com.company.launchmodemasterassis.R;
import com.company.launchmodemasterassis.Utils;
import com.company.launchmodemasterassis.domain.ActivityContent;

import java.util.ArrayList;
import java.util.List;


public class ActivityStartManager {

    private static ActivityStartManager instance;

    private String currentActivityName;
    private String currentActivityDesc;

    private List<ActivityContent> displayActivityList = new ArrayList<>();

    public static void init() {
        instance = new ActivityStartManager();
    }

    public static ActivityStartManager getInstance() {
        return instance;
    }

    private ActivityStartManager() {
        currentActivityName = AssisConstants.ASSIS_STANDARD_A1;

        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_STANDARD_A1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_STANDARD_A2, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TOP_B1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TOP_B2, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TASK_C1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TASK_C2, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_INSTANCE_D1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_INSTANCE_D2, "taskAffinity = com.hero.support"));

        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A5, "process = :work"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B5, "process = :work"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C5, "process = :work"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D5, "process = :work"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D9, "finishOnTaskLaunch = true"));

    }

    public ArrayList<ActivityContent> getAllActivityContent() {
        return new ArrayList<>(displayActivityList);
    }

    public void setCurrentActivityName(String currentActivityName) {
        this.currentActivityName = currentActivityName;
    }

    public String getCurrentActivityName() {
        return currentActivityName;
    }

    public String getCurrentActivityDesc() {
        return currentActivityDesc;
    }

    public void startActivityForResult(Activity activity) {
        startActivity(activity, true);
    }

    public void startActivity(Activity activity) {
        startActivity(activity, false);
    }

    private void startActivity(Activity activity, boolean isForResult) {
        if (TextUtils.isEmpty(currentActivityName)) {
            return;
        }

        switch (currentActivityName) {

            case AssisConstants.ASSIS_STANDARD_A1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_Standard_A1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_Standard_A1_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_STANDARD_A2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_Standard_A2_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_Standard_A2_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_TOP_B1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTop_B1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTop_B1_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_TOP_B2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTop_B2_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTop_B2_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_TASK_C1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTask_C1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTask_C1_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_TASK_C2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTask_C2_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleTask_C2_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_INSTANCE_D1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleInstance_D1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleInstance_D1_Activity.class)));
                }
                break;

            case AssisConstants.ASSIS_SINGLE_INSTANCE_D2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleInstance_D2_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Assis_SingleInstance_D2_Activity.class)));
                }
                break;


            case AssisConstants.STANDARD_A1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A2:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A2").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A3:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A3").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A4:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A4").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A5:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A5").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A6:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A6").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A6").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A7:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A7").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A7").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A8:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A8").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A8").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.STANDARD_A9:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A9").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A9").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B2:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B2").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }

                break;

            case AssisConstants.SINGLE_TOP_B3:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B3").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B4:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B4").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B5:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B5").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B6:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B6").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B6").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B7:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B7").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B7").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B8:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B8").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B8").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TOP_B9:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B9").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B9").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C2:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C2").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C3:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C3").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C4:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C4").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C5:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C5").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C6:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C6").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C6").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C7:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C7").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C7").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C8:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C8").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C8").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_TASK_C9:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C9").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C9").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D2:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D2").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D3:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D3").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D4:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D4").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D5:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D5").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D6:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D6").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D6").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D7:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D7").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D7").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D8:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D8").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D8").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D9:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D9").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D9").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterAssisApplication.getContext(), R.string.toast_hint_install_launch_mode_app, Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }
}
