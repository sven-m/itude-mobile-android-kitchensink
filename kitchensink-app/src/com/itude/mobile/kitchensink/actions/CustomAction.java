/*
 * (C) Copyright Itude Mobile B.V., The Netherlands
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    try
    {
      Thread.currentThread().sleep(5000);
    }
    catch (InterruptedException e)
    {
    }

    MBOutcome oc = new MBOutcome();
    oc.setOutcomeName("OUTCOME-display-device-info");
    oc.setNoBackgroundProcessing(true);
    oc.setTransferDocument(true);
    oc.setDocument(doc);

    return oc;
  }

}
