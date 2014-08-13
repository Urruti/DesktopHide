package org.urruti.desktop_hide;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class AfterMainAppIsUninstalled extends BroadcastReceiver {


	@Override
	public void onReceive(Context context, Intent arg1) {

			ComponentName comp= new ComponentName("org.urruti.desktop_hide", "org.urruti.desktop_hide.MainActivity");
			PackageManager p = context.getPackageManager();
			p.setComponentEnabledSetting(comp, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
			Intent i = new Intent();
	        i.setClassName("org.urruti.desktop_hide", "org.urruti.desktop_hide.MainActivity");
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        i.putExtra("selec", 1);
	        context.startActivity(i);
	    }

}
