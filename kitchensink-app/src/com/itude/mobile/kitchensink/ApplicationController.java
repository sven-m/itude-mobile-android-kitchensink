package com.itude.mobile.kitchensink;

import com.itude.mobile.mobbl2.client.core.controller.MBApplicationController;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationFactory;
import com.itude.mobile.mobbl2.client.core.services.MBMetadataService;

public class ApplicationController extends MBApplicationController
{

  @Override
  public void startController()
  {
    MBApplicationFactory.setInstance(new ApplicationFactory());
    MBMetadataService.setConfigName("config/config.xml");
    startApplication(ApplicationFactory.getInstance());
  }
}
