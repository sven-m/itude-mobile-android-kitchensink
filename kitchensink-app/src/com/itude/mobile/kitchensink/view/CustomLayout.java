package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.view.MBPanel;

public class CustomLayout extends MBBasicViewController
{
  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    MBPanel panel = getPage().getFirstChildOfKindWithName(MBPanel.class, "myPanel");
    ViewGroup view = panel.buildView();
    view.setPadding(100, 100, 0, 0);
    return view;
  }
}
