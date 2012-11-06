package com.itude.mobile.kitchensink;

import android.webkit.WebChromeClient.CustomViewCallback;

import com.itude.mobile.kitchensink.actions.CustomAction;
import com.itude.mobile.kitchensink.view.CustomViewLogic;
import com.itude.mobile.mobbl2.client.core.actions.MBFireInitialOutcomes;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationFactory;

public class ApplicationFactory extends MBApplicationFactory
{

  @Override
  protected ActionMappings.Registry getActionRegistry()
  {
    ActionMappings.Registry registry = new ActionMappings.Registry()
    {

      @Override
      protected void registerMappings()
      {
        registerAction("FireInitialOutcomes", MBFireInitialOutcomes.class);
        registerAction("CustomAction", CustomAction.class);
      }

    };
    return registry;
  }

  @Override
  protected ControllerMappings.Registry getControllerRegistry()
  {
    ControllerMappings.Registry registry = new ControllerMappings.Registry()
    {

      @Override
      protected void registerMappings()
      {
        registerController("PAGE-customized-view-logic", CustomViewLogic.class);
      }
    };

    return registry;
  }
}
