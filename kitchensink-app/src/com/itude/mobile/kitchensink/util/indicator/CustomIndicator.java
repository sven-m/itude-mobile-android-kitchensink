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
