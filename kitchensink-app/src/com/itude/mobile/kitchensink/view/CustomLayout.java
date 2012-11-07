package com.itude.mobile.kitchensink.view;

import android.view.ViewGroup;

import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.view.MBPanel;

public class CustomLayout extends MBBasicViewController
{
@Override
protected ViewGroup buildInitialView()
{
 MBPanel panel = getPage().getFirstChildOfKindWithName(MBPanel.class, "myPanel");
 ViewGroup view = panel.buildViewWithMaxBounds(getPage().getCurrentViewState());
 view.setPadding(100, 100, 0, 0);
 return view;
}
}
