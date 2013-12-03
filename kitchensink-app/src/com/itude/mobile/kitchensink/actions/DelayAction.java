package com.itude.mobile.kitchensink.actions;

import com.itude.mobile.mobbl2.client.core.MBException;
import com.itude.mobile.mobbl2.client.core.controller.MBAction;
import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;

public class DelayAction implements MBAction
{

  @Override
  public MBOutcome execute(MBDocument document, String path)
  {
    try
    {
      Thread.sleep(5000);
    }
    catch (InterruptedException e)
    {
      throw new MBException("Meh", e);
    }
    return null;
  }

}
