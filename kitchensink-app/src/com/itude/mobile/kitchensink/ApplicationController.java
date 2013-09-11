package com.itude.mobile.kitchensink;

import com.itude.mobile.kitchensink.services.OAuthRestServiceDataHandler;
import com.itude.mobile.kitchensink.styling.CustomPanelBuilder;
import com.itude.mobile.kitchensink.styling.StyleHandler;
import com.itude.mobile.kitchensink.util.CustomShutdownHandler;
import com.itude.mobile.kitchensink.util.FirstLetterFormatter;
import com.itude.mobile.kitchensink.util.indicator.CustomIndicator;
import com.itude.mobile.kitchensink.view.ListViewBuilder;
import com.itude.mobile.kitchensink.view.SectionMarkerFieldViewBuilder;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationController;
import com.itude.mobile.mobbl2.client.core.controller.MBApplicationFactory;
import com.itude.mobile.mobbl2.client.core.controller.MBViewManager;
import com.itude.mobile.mobbl2.client.core.controller.util.indicator.MBIndicatorController;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;
import com.itude.mobile.mobbl2.client.core.services.MBMetadataService;
import com.itude.mobile.mobbl2.client.core.util.Constants;
import com.itude.mobile.mobbl2.client.core.view.builders.MBViewBuilderFactory;
import com.itude.mobile.mobbl2.client.core.view.builders.datatypes.MBDataTypeFormatterFactory;

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

    MBDataManagerService.getInstance().registerDataHandler(new OAuthRestServiceDataHandler(), "OAuthRestServiceDataHandler");

    MBViewBuilderFactory.getInstance().getPanelViewBuilder().registerBuilder(KitchenSinkConstants.C_PANEL_LISTVIEW, new ListViewBuilder());
    MBViewBuilderFactory.getInstance().getFieldViewBuilder()
        .registerBuilder(SectionMarkerFieldViewBuilder.TYPE, new SectionMarkerFieldViewBuilder());

    MBDataTypeFormatterFactory.getInstance().registerFormatter("firstLetter", new FirstLetterFormatter());

    MBViewManager.getInstance().setShutdownHandler(new CustomShutdownHandler());

    MBIndicatorController.getInstance().setActivityIndicator(new CustomIndicator());

    startApplication(ApplicationFactory.getInstance());
  }
}
