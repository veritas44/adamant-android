package im.adamant.android.ui.transformations;

import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.RequiresApi;

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public class PassphraseAvatarOutlineProvider extends ViewOutlineProvider {

    @Override
    public void getOutline(View view, Outline outline) {
        outline.setOval(0 , 0, view.getRight() - view.getLeft(), view.getBottom() - view.getTop());
    }
}