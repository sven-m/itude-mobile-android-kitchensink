package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.kitchensink.view.binding.BaseViewBinder;
import com.itude.mobile.kitchensink.view.binding.EditTextBinder;
import com.itude.mobile.kitchensink.view.binding.ListViewBinder;
import com.itude.mobile.kitchensink.view.binding.PageBinder;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;

public class ViewBindingController extends MBBasicViewController
{

  public static class PlantBinder extends BaseViewBinder
  {

    @Override
    protected View bindSpecificView(BuildState state)
    {
      ViewGroup plant = (ViewGroup) (state.recycledView != null ? state.recycledView : state.inflater.inflate(R.layout.plant_layout,
                                                                                                              state.parent, false));

      String name = state.element.getValueForPath("COMMON[0]/@text()");
      String botanicalName = state.element.getValueForPath("BOTANICAL[0]/@text()");

      TextView nameView = (TextView) plant.findViewById(R.id.commonName);
      nameView.setText(name);

      TextView botanicalNameView = (TextView) plant.findViewById(R.id.botanicalName);
      botanicalNameView.setText(botanicalName);

      return plant;
    }

  }

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    PageBinder binder = new PageBinder(inflater, this);
    binder.registerBinding("PlantList", ListViewBinder.getInstance(android.R.id.list));
    binder.registerBinding("Plant", new PlantBinder());
    binder.registerBinding("Light", EditTextBinder.getInstance(R.id.light));
    return binder.bind(R.layout.modern_layout);
  }

}
