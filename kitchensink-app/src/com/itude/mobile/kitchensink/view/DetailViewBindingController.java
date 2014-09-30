package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.kitchensink.view.binding.PageBinder;
import com.itude.mobile.kitchensink.view.binding.TextBinder;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;

public class DetailViewBindingController extends MBBasicViewController
{

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    PageBinder binder = new PageBinder(inflater, this);
    binder.registerBinding("Light", TextBinder.getInstance(R.id.light));
    binder.registerBinding("CommonName", TextBinder.getInstance(R.id.commonName));
    binder.registerBinding("BotanicalName", TextBinder.getInstance(R.id.botanicalName));
    binder.registerBinding("Zone", TextBinder.getInstance(R.id.zone));
    binder.registerBinding("Price", TextBinder.getInstance(R.id.price));
    binder.registerBinding("Availability", TextBinder.getInstance(R.id.availability));
    return binder.bind(R.layout.plant_detail_layout);
  }

}
