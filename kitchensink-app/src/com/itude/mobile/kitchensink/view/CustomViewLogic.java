package com.itude.mobile.kitchensink.view;

import android.view.ViewGroup;
import android.widget.Toast;

import com.itude.mobile.mobbl2.client.core.controller.MBOutcome;
import com.itude.mobile.mobbl2.client.core.controller.MBViewManager;
import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.view.MBOutcomeListenerProtocol;
import com.itude.mobile.mobbl2.client.core.view.MBValueChangeListenerProtocol;

public class CustomViewLogic extends MBBasicViewController implements MBValueChangeListenerProtocol, MBOutcomeListenerProtocol
{

  private static final String GENDER_PATH   = "/Form[0]/@gender";
  private static final String COMMENT_PATH  = "/Form[0]/@comment";
  private static final String CHECKBOX_PATH = "/Form[0]/@checkbox";

  @Override
  protected ViewGroup buildInitialView()
  {
    ViewGroup view = super.buildInitialView();

    getPage().registerValueChangeListener(this, GENDER_PATH);
    getPage().registerValueChangeListener(this, CHECKBOX_PATH);
    getPage().registerOutcomeListener(this);

    return view;
  }

  @Override
  public void outcomeProduced(MBOutcome outcome)
  {
    Toast.makeText(MBViewManager.getInstance(), "Intercepted outcome " + outcome.toString(), Toast.LENGTH_LONG).show();
  }

  @Override
  public boolean valueWillChange(String value, String originalValue, String path)
  {
    return true;
  }

  @Override
  public void valueChanged(String value, String originalValue, String path)
  {
    if (path.equals(GENDER_PATH))
    {
      if (value.equals("male"))

      getPage().getDocument().setValue("Watch My Little Pony", COMMENT_PATH);
      else getPage().getDocument().setValue("Watch Justin Bieber", COMMENT_PATH);
    }

    rebuildView(true);

  }

  @Override
  public void afterOutcomeHandled(MBOutcome outcome)
  {
  }

}
