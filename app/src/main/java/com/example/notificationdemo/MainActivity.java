package com.example.notificationdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void notify(View view) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle("You got notification");
		mBuilder.setContentText("Hi, This is Android Notification Detail!");
		mBuilder.setAutoCancel(true);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		// notificationID allows you to update the notification later on.
		mNotificationManager.notify(1, mBuilder.build());
	}

	public void notifyActivity(View view) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(
				this);
		mBuilder2.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle("You got notification 2");
		mBuilder.setContentText("Hi, This is Android Notification Detail!");
		mBuilder.setAutoCancel(true);// remove and show

		// A PendingIntent object helps you to perform an action on your
		// application’s behalf, often at a later time, without caring of
		// whether or not your application is running.

		Intent intent = new Intent(this, SecondActivity.class);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
				intent, 0);
		/*
		 * int FLAG_CANCEL_CURRENT Flag indicating that if the described
		 * PendingIntent already exists, the current one should be canceled
		 * before generating a new one. int FLAG_NO_CREATE Flag indicating that
		 * if the described PendingIntent does not already exist, then simply
		 * return null instead of creating it. int FLAG_ONE_SHOT Flag indicating
		 * that this PendingIntent can be used only once. int
		 * FLAG_UPDATE_CURRENT Flag indicating that if the described
		 * PendingIntent already exists, then keep it but replace its extra data
		 * with what is in this new Intent
		 */

		mBuilder.setContentIntent(resultPendingIntent);

		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// notificationID allows you to update the notification later on.
		mNotificationManager.notify(1, mBuilder.build());
		//mNotificationManager.notify(1, mBuilder2.build());
	}

	public void alertDialog(View view) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage("I am Alert");
		alertDialogBuilder.setPositiveButton("+ve",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(getApplicationContext(), "+ve clicked", Toast.LENGTH_LONG).show();

					}
				});
		alertDialogBuilder.setNegativeButton("-ve",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), "-ve clicked", Toast.LENGTH_LONG).show();
					}
				});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
	public void progressDialog(View view){
		ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("loading");
		//pd.setCancelable(false);// try this
		pd.show();
		
	}

}
