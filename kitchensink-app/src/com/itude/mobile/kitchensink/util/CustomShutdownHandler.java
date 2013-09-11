package com.itude.mobile.kitchensink.util;

import com.itude.mobile.mobbl2.client.core.controller.MBShutdownHandler;

public class CustomShutdownHandler extends MBShutdownHandler
{

  @Override
  public void onShutdown()
  {
    finish();
  }

}
