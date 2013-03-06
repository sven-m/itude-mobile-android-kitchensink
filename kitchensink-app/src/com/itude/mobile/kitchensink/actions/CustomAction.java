package com.itude.mobile.kitchensink.actions;

import com.itude.mobile.android.util.DeviceUtil;
import com.itude.mobile.mobbl2.client.core.controller.MBAction;
import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.model.MBDocument;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;

public class CustomAction implements MBAction
{

  @Override
  public MBOutcome execute(MBDocument document, String path)
  {

    MBDocument doc = MBDataManagerService.getInstance().loadDocument("ApplicationState");
    doc.setValue(DeviceUtil.getInstance().getDeviceType(), "Device[0]/@deviceType");

    MBOutcome oc = new MBOutcome();
    oc.setOutcomeName("OUTCOME-display-device-info");
    oc.setNoBackgroundProcessing(true);
    oc.setTransferDocument(true);
    oc.setDocument(doc);

    return oc;
  }

}
