package com.itude.mobile.kitchensink;

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
      }

    };
    return registry;
  }

}
