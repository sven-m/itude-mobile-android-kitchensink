/*
 * (C) Copyright Itude Mobile B.V., The Netherlands
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.itude.mobile.kitchensink.styling;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.itude.mobile.kitchensink.KitchenSinkConstants;
import com.itude.mobile.mobbl.core.controller.MBApplicationController;
import com.itude.mobile.mobbl.core.services.MBResourceService;
import com.itude.mobile.mobbl.core.view.MBPanel;
import com.itude.mobile.mobbl.core.view.builders.MBPanelViewBuilder;
import com.itude.mobile.mobbl.core.view.builders.MBPanelViewBuilder.BuildState;
import com.itude.mobile.mobbl.core.view.builders.MBViewBuilder;

public class CustomPanelBuilder extends MBViewBuilder implements MBPanelViewBuilder.Builder
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
    if (panel.getOutcomeName() != null)
    {
      layout.setClickable(true);
      layout.setFocusable(true);
      layout.setOnClickListener(panel);
    }

    buildChildren(panel.getChildren(), layout);

    return layout;
  }

}
