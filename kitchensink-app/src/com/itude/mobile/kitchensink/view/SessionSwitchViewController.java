package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itude.mobile.mobbl2.client.core.controller.MBViewManager;
import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;
import com.itude.mobile.mobbl2.client.core.view.MBValueChangeListenerProtocol;

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
