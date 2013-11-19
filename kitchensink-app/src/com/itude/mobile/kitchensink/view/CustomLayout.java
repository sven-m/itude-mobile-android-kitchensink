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

import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.view.MBPanel;

public class CustomLayout extends MBBasicViewController
{
  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    MBPanel panel = getPage().getFirstChildOfKindWithName(MBPanel.class, "myPanel");
    ViewGroup view = panel.buildView();
    view.setPadding(100, 100, 0, 0);
    return view;
  }
}
