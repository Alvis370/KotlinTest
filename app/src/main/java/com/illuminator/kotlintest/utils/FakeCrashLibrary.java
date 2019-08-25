package com.illuminator.kotlintest.utils;

/**
 * Created by Android Studio.
 * User: LiGe
 * Date: 2019/8/21
 * Time: 14:45
 */
public final class FakeCrashLibrary {
    /** Not a real crash reporting library! */
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }
}