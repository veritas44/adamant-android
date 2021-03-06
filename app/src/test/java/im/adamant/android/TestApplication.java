package im.adamant.android;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.franmontiel.localechanger.LocaleChanger;
import com.google.firebase.FirebaseApp;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import androidx.multidex.MultiDexApplication;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import im.adamant.android.dagger.DaggerTestAppComponent;
import im.adamant.android.helpers.LoggerHelper;
import io.reactivex.plugins.RxJavaPlugins;

public class TestApplication  extends MultiDexApplication implements HasActivityInjector, HasServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidActivityInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingAndroidServiceInjector;

//    @Inject
//    List<Locale> supportedLocales;

    @Override
    public void onCreate() {
        super.onCreate();

        RxJavaPlugins.setErrorHandler(e -> LoggerHelper.e("UNCAUGHT RX", e.getMessage(), e));

        DaggerTestAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this);

        FirebaseApp.initializeApp(this);

//        LocaleChanger.initialize(getApplicationContext(), supportedLocales);

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidActivityInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingAndroidServiceInjector;
    }


    public static void hideKeyboard(Context ctx, View view) {
        InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Context ctx, View view, int flags) {
        InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(), flags);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleChanger.onConfigurationChanged();
    }
}
