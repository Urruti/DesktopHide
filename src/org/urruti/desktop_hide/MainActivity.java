package org.urruti.desktop_hide;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 boolean installed  =   appInstalledOrNot("org.urruti.webclinic");  
			if(installed)
			{
				PackageManager p = getPackageManager();
			    p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
			}
			else
				{
				
				}
			Intent pre = getIntent();
			int selec = pre.getIntExtra("selec", 0);
			if (selec ==0)
			{
		    setContentView(R.layout.activity_main);
			}
			else
			{
				finish();
			}

	}

	
    private boolean appInstalledOrNot(String uri)
    {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try
        {
               pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
               app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
               app_installed = false;
        }
        return app_installed ;
}

}
