package com.itude.mobile.kitchensink.styling;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.itude.mobile.kitchensink.KitchenSinkConstants;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationController;
import com.itude.mobile.mobbl2.client.core.services.MBResourceService;
import com.itude.mobile.mobbl2.client.core.view.MBPanel;
import com.itude.mobile.mobbl2.client.core.view.builders.MBPanelViewBuilder.BuildState;
import com.itude.mobile.mobbl2.client.core.view.builders.MBPanelViewBuilder.Builder;
import com.itude.mobile.mobbl2.client.core.view.builders.MBViewBuilder;

public class CustomRowFieldBuilder extends MBViewBuilder implements Builder
{

  @Override
  public ViewGroup buildPanel(MBPanel panel, BuildState buildState)
  {
    final Context context = MBApplicationController.getInstance().getBaseContext();
    LinearLayout layout = new LinearLayout(context);
    layout.setOrientation(LinearLayout.HORIZONTAL);
    layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

    String ponyName = panel.getCustom(KitchenSinkConstants.C_ATTR_PONY);
    Drawable pinkie = MBResourceService.getInstance().getImageByID(ponyName);

    ImageView image = new ImageView(context);
    image.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    image.setImageDrawable(pinkie);
    layout.addView(image);

    buildChildren(panel.getChildren(), layout);

    return layout;
  }

}
