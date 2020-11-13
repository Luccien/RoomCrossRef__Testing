package eu.de.servicetestfragment.ui.main.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import eu.de.servicetestfragment.R
import eu.de.servicetestfragment.ui.main.other.Constants.Action_Start_Or_Resume_Service
import eu.de.servicetestfragment.ui.main.other.Constants.Action_Start_Or_Resume_Service2
import eu.de.servicetestfragment.ui.main.other.Constants.NOTIFICATION_CHANNEL_ID
import eu.de.servicetestfragment.ui.main.other.Constants.NOTIFICATION_CHANNEL_NAME
import eu.de.servicetestfragment.ui.main.other.Constants.NOTIFICATION_ID


class TestService: LifecycleService() {

    var isFirstRun = true

    // gets called whenever send a intent from the fragment with the COMMAND attached!!
        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let{
            when(it.action){
                Action_Start_Or_Resume_Service ->{
                   // val intent = intent
                    val name = it.getStringExtra("Name")
                  if(isFirstRun){
                      startForegroundService(name)
                      isFirstRun = false
                  }
                  else{
                      // LATER
                  }
                    //Timber.d("StartOrResumeService")
                    println("heyyyyyyy111")
                    //it.testSt1
                }
                Action_Start_Or_Resume_Service2 ->{
                    //Timber.d("StartOrResumeService")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun startForegroundService(name:String){

        /// ------ CUSTOM CODE FOR OREO!!
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
        as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(notificationManager)
        }
        /// ------ END CUSTOM CODE FOR OREO
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_announcement)
            .setContentTitle("running..")
            .setContentText(name)//HELLO content text")
        // for opening fragment with global action!
        //.setContentIntent(getMainActivityPendingIntent())
        //.  BEI 10 Minuten!!!

        startForeground(NOTIFICATION_ID,notificationBuilder.build())

    }
    // FOR opening fragment (with global action)
   // --->> ADD LATER video 12: 10min private fun getMainActivityPendingIntent() = PendingIntent.getActivity(XXXXLATER)


    /// ------>>>> CUSTOM CODE FOR OREO!!
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager){
        val channel =
            NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                IMPORTANCE_LOW // 2 IMPORT POSSIBILIETIES NOT SURE PICKED RIGHT ONE
                )

    }

}