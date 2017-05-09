package com.company.launchmodemasterassis.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;


import com.company.launchmodemasterassis.Assis_SingleInstance_D1_Activity;
import com.company.launchmodemasterassis.Assis_SingleTask_C1_Activity;
import com.company.launchmodemasterassis.Assis_SingleTop_B1_Activity;
import com.company.launchmodemasterassis.Assis_Standard_A1_Activity;
import com.company.launchmodemasterassis.AssisConstants;
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
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TOP_B1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_TASK_C1, "Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.ASSIS_SINGLE_INSTANCE_D1, "Normal"));

        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A2, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A3, "Other App taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A4, "Other App taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(AssisConstants.STANDARD_A5, "Other App process = :work"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B2, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B3, "Other App taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B4, "Other App taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TOP_B5, "Other App process = :work"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C2, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C3, "Other App taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C4, "Other App taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_TASK_C5, "Other App process = :work"));

        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D2, "Other App Normal"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D3, "Other App taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D4, "Other App taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(AssisConstants.SINGLE_INSTANCE_D5, "Other App process = :work"));

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

            case AssisConstants.ASSIS_SINGLE_TOP_B1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Assis_SingleTop_B1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Assis_SingleTop_B1_Activity.class)));
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

            case AssisConstants.ASSIS_SINGLE_INSTANCE_D1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Assis_SingleInstance_D1_Activity.class)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Assis_SingleInstance_D1_Activity.class)));
                }

                break;


            case AssisConstants.STANDARD_A1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)));
                }

                break;

            case AssisConstants.STANDARD_A2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A2").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.STANDARD_A3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A3").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.STANDARD_A4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A4").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.STANDARD_A5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.STANDARD_A5").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TOP_B1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TOP_B2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B2").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TOP_B3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B3").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TOP_B4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B4").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TOP_B5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TOP_B5").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TASK_C1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TASK_C2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C2").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TASK_C3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C3").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TASK_C4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C4").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_TASK_C5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_TASK_C5").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D2").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D2").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D3").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D3").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D4").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D4").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case AssisConstants.SINGLE_INSTANCE_D5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D5").addCategory(Intent.CATEGORY_DEFAULT)), 1);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master.SINGLE_INSTANCE_D5").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            default:
                break;
        }
    }
}
