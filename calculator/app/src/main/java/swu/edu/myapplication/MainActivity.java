package swu.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "lifeCycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifeCycle", "MainActivity: 我是onCreate方法，我会在Activity第一次被创建是调用");
    }


    @Override
    protected void onStart() {

        super.onStart();
        Log.d("lifeCycle", "MainActivity: 我是onStart方法，" +
                "我会在Activity由不可见变为可见时调用");
    }

    @Override
     protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "MainActivity: 我是onResume方法，我在" +
                "Activity处于运行状态时调用");
    }

    @Override
     protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "MainActivity: 我是onPause方法，我会在Activity暂停时调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "MainActivity: 我是onStop方法，我会在Activity停止时调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycle", "MainActivity: 我是onRestart方法，我会在Activty从停止状态变为运行状态时调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "MainActivity: 我是onDestroy方法，我会在Activty销毁之前调用");
    }

    public void onClick(View view){



    }
}