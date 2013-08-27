package com.itude.mobile.kitchensink.util.indicator;

import android.app.Activity;
import android.app.ProgressDialog;

import com.itude.mobile.kitchensink.KitchenSinkConstants;
import com.itude.mobile.mobbl2.client.core.controller.util.indicator.MBCountingIndicator;
import com.itude.mobile.mobbl2.client.core.util.MBCustomAttributeContainer;

public class CustomIndicator extends MBCountingIndicator
{

  private ProgressDialog _dialog = null;

  @Override
  protected void show(final Activity activity, MBCustomAttributeContainer container)
  {
    _dialog = ProgressDialog.show(activity, "Trolololo..", container.getCustom(KitchenSinkConstants.C_ATTR_INDICATOR_STATUS), true, false);
  }

  @Override
  protected void dismiss(final Activity activity)
  {

    _dialog.dismiss();
    _dialog = null;
  }
}
