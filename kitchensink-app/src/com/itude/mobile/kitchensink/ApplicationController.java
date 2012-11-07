package com.itude.mobile.kitchensink;

import com.itude.mobile.kitchensink.styling.StyleHandler;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationController;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationFactory;
import com.itude.mobile.mobbl2.client.core.services.MBMetadataService;
import com.itude.mobile.mobbl2.client.core.view.builders.MBViewBuilderFactory;

public class ApplicationController extends MBApplicationController
{

  @Override
  public void startController()
  {
    MBApplicationFactory.setInstance(new ApplicationFactory());
    MBMetadataService.setConfigName("config/config.xml");

    MBViewBuilderFactory.getInstance().setStyleHandler(new StyleHandler());

    startApplication(ApplicationFactory.getInstance());
  }
}
