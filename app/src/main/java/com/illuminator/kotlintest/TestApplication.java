package com.illuminator.kotlintest;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import com.illuminator.kotlintest.utils.FakeCrashLibrary;
import timber.log.Timber;

/**
 * Created by Android Studio.
 * User: LiGe
 * Date: 2019/8/21
 * Time: 14:41
 */
public class TestApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    private static class CrashReportingTree extends Timber.Tree {
        @Override protected void log(int priority, String tag, @NonNull String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            FakeCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
