package com.itude.mobile.kitchensink.actions.search;

import com.itude.mobile.mobbl2.client.core.controller.MBAction;
import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.controller.MBViewManager;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;

public class DisplaySearchAction implements MBAction
{

  public MBOutcome execute(MBDocument document, String path)
  {
    MBViewManager.getInstance().onSearchRequested();

    return null;
  }

}