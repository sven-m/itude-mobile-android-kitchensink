package com.itude.mobile.kitchensink.view.binding;

import android.view.View;
import android.view.ViewGroup;

import com.itude.mobile.mobbl.core.model.MBElement;
import com.itude.mobile.mobbl.core.model.MBElementContainer;
import com.itude.mobile.mobbl.core.view.MBComponent;

public abstract class BaseViewBinder implements ViewBinder
{

  @Override
  public View bindView(BuildState state)
  {
    View result = bindSpecificView(state);
    if (result != null) state.component.attachView(result);

    // process children
    for (MBComponent child : state.component.getChildrenOfKind(MBComponent.class))
    {
      state.component = child;
      Object element = child.getDocument().getValueForPath(child.getAbsoluteDataPath());
      state.element = (MBElementContainer) (element instanceof MBElement ? element : null);
      state.parent = (ViewGroup) (result instanceof ViewGroup ? result : state.parent);
      state.mainViewBinder.bindView(state);
    }

    return result;
  }

  protected abstract View bindSpecificView(BuildState state);

}
