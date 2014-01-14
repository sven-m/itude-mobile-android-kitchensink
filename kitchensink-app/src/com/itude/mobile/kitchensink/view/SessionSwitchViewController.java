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
package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itude.mobile.mobbl.core.controller.MBViewManager;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl.core.services.MBDataManagerService;
import com.itude.mobile.mobbl.core.view.MBValueChangeListenerProtocol;

public class SessionSwitchViewController extends MBBasicViewController implements MBValueChangeListenerProtocol
{

  private static final String SESSION_TYPE_PATH = "/Type[0]/@text()";

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    ViewGroup view = super.buildInitialView(inflater);

    getPage().registerValueChangeListener(this, SESSION_TYPE_PATH);
    return view;
  }

  @Override
  public boolean valueWillChange(String value, String originalValue, String path)
  {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void valueChanged(String value, String originalValue, String path)
  {
    MBDataManagerService.getInstance().storeDocument(getPage().getDocument());
    MBViewManager.getInstance().reset();
  }

}
