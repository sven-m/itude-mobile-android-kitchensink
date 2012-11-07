package com.itude.mobile.kitchensink.actions;

import com.itude.mobile.mobbl2.client.core.MBException;
import com.itude.mobile.mobbl2.client.core.controller.MBAction;
import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;

public class ExceptionAction implements MBAction
{

  @Override
  public MBOutcome execute(MBDocument document, String path)
  {
    throw new MBException("Crashypants!");
  }

}
