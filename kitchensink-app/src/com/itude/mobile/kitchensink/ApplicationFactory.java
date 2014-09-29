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
package com.itude.mobile.kitchensink;

import com.itude.mobile.kitchensink.actions.CustomAction;
import com.itude.mobile.kitchensink.actions.DelayAction;
import com.itude.mobile.kitchensink.actions.ExceptionAction;
import com.itude.mobile.kitchensink.actions.search.DisplaySearchAction;
import com.itude.mobile.kitchensink.actions.search.SearchAction;
import com.itude.mobile.kitchensink.view.CustomLayout;
import com.itude.mobile.kitchensink.view.CustomViewLogic;
import com.itude.mobile.kitchensink.view.LayoutBasedViewController;
import com.itude.mobile.kitchensink.view.OrderedListViewController;
import com.itude.mobile.kitchensink.view.SessionSwitchViewController;
import com.itude.mobile.kitchensink.view.SlidingMenuContentWrapper;
import com.itude.mobile.kitchensink.view.ViewBindingController;
import com.itude.mobile.mobbl.core.actions.MBFireInitialOutcomes;
import com.itude.mobile.mobbl.core.controller.MBApplicationFactory;
import com.itude.mobile.mobbl.core.view.builders.MBContentViewWrapper;

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
        registerAction("CustomAction", CustomAction.class);
        registerAction("ExceptionExampleAction", ExceptionAction.class);
        registerAction("SearchAction", SearchAction.class);
        registerAction("DisplaySearchAction", DisplaySearchAction.class);
        registerAction("DelayAction", DelayAction.class);
      }

    };
    return registry;
  }

  @Override
  protected ControllerMappings.Registry getControllerRegistry()
  {
    ControllerMappings.Registry registry = new ControllerMappings.Registry()
    {

      @Override
      protected void registerMappings()
      {
        registerController("PAGE-customized-view-logic", CustomViewLogic.class);
        registerController("PAGE-customized-layout", CustomLayout.class);
        registerController("PAGE-page-with-xib", LayoutBasedViewController.class);
        registerController("PAGE-catalog", OrderedListViewController.class);
        registerController("PAGE-session-switcher", SessionSwitchViewController.class);
        registerController("PAGE-modern-catalog", ViewBindingController.class);
      }
    };

    return registry;
  }

  @Override
  public MBContentViewWrapper createContentViewWrapper()
  {
    return new SlidingMenuContentWrapper();
  }
}
