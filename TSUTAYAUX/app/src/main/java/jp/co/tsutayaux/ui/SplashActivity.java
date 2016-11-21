
package jp.co.tsutayaux.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.util.Constant;

/**
 * Created by DuongND on 11/15/2016.
 */
public class SplashActivity extends Activity {
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mProgressBar = (ProgressBar) findViewById(R.id.splash_progress_bar);
        if (mThread != null && !SplashActivity.this.isFinishing()) {
            mThread.interrupt();
        }
        // This thread will sleep about 2 seconds in time of showing flash image
        if (mThread != null) {
            mThread.start();
        }
    }

    private static final int SLEEP_TIME = 2000;
    private Thread mThread = new Thread() {
        @Override
        public void run() {
            // TODO
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nextActivity();
            }
        }
    };

    private void nextActivity() {
        if (Constant.getPrefs(this).getBoolean(Constant.FIRST_LAUNCHER, true)) {
            startActivity(new Intent(this, GuiderActivity.class));
        } else {
            startActivity(new Intent(this, MainTabActivity.class));
        }
        finish();
    }

}
