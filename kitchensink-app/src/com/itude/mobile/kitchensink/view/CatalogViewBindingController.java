package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.kitchensink.view.binding.BaseViewBinder;
import com.itude.mobile.kitchensink.view.binding.ListViewBinder;
import com.itude.mobile.kitchensink.view.binding.PageBinder;
import com.itude.mobile.kitchensink.view.binding.TextBinder;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;

public class CatalogViewBindingController extends MBBasicViewController
{

  public static class PlantBinder extends BaseViewBinder
  {

    @Override
    protected View bindSpecificView(BuildState state)
    {
      ViewGroup plant = (ViewGroup) (state.recycledView != null ? state.recycledView : state.inflater.inflate(R.layout.plant_layout,
                                                                                                              state.parent, false));
      return plant;
    }

  }

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    PageBinder binder = new PageBinder(inflater, this);
    binder.registerBinding("PlantList", ListViewBinder.getInstance(android.R.id.list));
    binder.registerBinding("Plant", new PlantBinder());
    binder.registerBinding("Light", TextBinder.getInstance(R.id.light));
    binder.registerBinding("CommonName", TextBinder.getInstance(R.id.commonName));
    binder.registerBinding("BotanicalName", TextBinder.getInstance(R.id.botanicalName));
    return binder.bind(R.layout.modern_layout);
  }

  @Override
  public void handleOnWindowActivated()
  {
    rebuildView(true);
  }

}