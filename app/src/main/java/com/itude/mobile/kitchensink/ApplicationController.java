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

import com.itude.mobile.kitchensink.styling.CustomPanelBuilder;
import com.itude.mobile.kitchensink.styling.StyleHandler;
import com.itude.mobile.kitchensink.util.formatter.FirstLetterFormatter;
import com.itude.mobile.kitchensink.util.handler.CustomShutdownHandler;
import com.itude.mobile.kitchensink.util.indicator.CustomIndicator;
import com.itude.mobile.kitchensink.view.ListViewBuilder;
import com.itude.mobile.kitchensink.view.SectionMarkerFieldViewBuilder;
import com.itude.mobile.mobbl.core.controller.MBApplicationController;
import com.itude.mobile.mobbl.core.controller.MBApplicationFactory;
import com.itude.mobile.mobbl.core.controller.MBViewManager;
import com.itude.mobile.mobbl.core.controller.util.indicator.MBIndicatorController;
import com.itude.mobile.mobbl.core.services.MBMetadataService;
import com.itude.mobile.mobbl.core.util.Constants;
import com.itude.mobile.mobbl.core.view.builders.MBViewBuilderFactory;
import com.itude.mobile.mobbl.core.view.builders.datatypes.MBDataTypeFormatterFactory;

public class ApplicationController extends MBApplicationController
{

  @Override
  public void startController()
  {
    MBApplicationFactory.setInstance(new ApplicationFactory());

    MBMetadataService.setConfigName("config/config.xml");
    MBMetadataService.setEndpointsName("config/endpoints.xml");

    MBViewBuilderFactory.getInstance().setStyleHandler(new StyleHandler());

    MBViewBuilderFactory.getInstance().getPanelViewBuilder()
        .registerBuilder(KitchenSinkConstants.C_PANEL_AWESOMEROW, new CustomPanelBuilder());

    MBViewBuilderFactory.getInstance().getPanelViewBuilder()
        .registerBuilder(Constants.C_ROW, KitchenSinkConstants.C_STYLE_AWESOME, new CustomPanelBuilder());

    MBViewBuilderFactory.getInstance().getPanelViewBuilder().registerBuilder(KitchenSinkConstants.C_PANEL_LISTVIEW, new ListViewBuilder());
    MBViewBuilderFactory.getInstance().getFieldViewBuilder()
        .registerBuilder(SectionMarkerFieldViewBuilder.TYPE, new SectionMarkerFieldViewBuilder());

    MBDataTypeFormatterFactory.getInstance().registerFormatter("firstLetter", new FirstLetterFormatter());

    MBViewManager.getInstance().setShutdownHandler(new CustomShutdownHandler());

    MBIndicatorController.getInstance().setActivityIndicator(new CustomIndicator());

    startApplication(ApplicationFactory.getInstance());
  }
}
