package com.itude.mobile.kitchensink.styling;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.itude.mobile.mobbl2.client.core.view.MBField;
import com.itude.mobile.mobbl2.client.core.view.builders.MBStyleHandler;

public class StyleHandler extends MBStyleHandler
{
  @Override
  public void styleLabel(TextView view, MBField field)
  {
    super.styleLabel(view, field);

    if (field != null)
    {
      if ("style2".equals(field.getStyle()))
      {
        view.setBackgroundResource(android.R.color.holo_red_light);
      }
      else if ("style3".equals(field.getStyle()))
      {
        view.setBackgroundResource(android.R.color.holo_purple);
      }
    }
  }

  @Override
  public void styleListPanel(LinearLayout view, String style, boolean notDirectChildOfSection)
  {
    super.styleListPanel(view, style, notDirectChildOfSection);

    if ("style1".equals(style)) view.setBackgroundResource(android.R.color.white);
  }
}
