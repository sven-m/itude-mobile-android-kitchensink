package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.kitchensink.view.binding.CompoundButtonBinder;
import com.itude.mobile.kitchensink.view.binding.EmptyBinder;
import com.itude.mobile.kitchensink.view.binding.PageBinder;
import com.itude.mobile.kitchensink.view.binding.RatingBarBinder;
import com.itude.mobile.kitchensink.view.binding.SpinnerBinder;
import com.itude.mobile.kitchensink.view.binding.TextBinder;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;

public class DetailViewBindingController extends MBBasicViewController
{

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    PageBinder binder = new PageBinder(inflater, this);
    binder.registerBinding("Light", SpinnerBinder.getInstance(R.id.light));
    binder.registerBinding("CommonName", TextBinder.getInstance(R.id.commonName));
    binder.registerBinding("BotanicalName", TextBinder.getInstance(R.id.botanicalName));
    binder.registerBinding("Zone", RatingBarBinder.getInstance(R.id.zone));
    binder.registerBinding("Price", TextBinder.getInstance(R.id.price));
    binder.registerBinding("Availability", TextBinder.getInstance(R.id.availability));
    binder.registerBinding("Coolness", CompoundButtonBinder.getInstance(R.id.coolness));
    binder.registerBinding("Back", EmptyBinder.getInstance(R.id.back));

    return binder.bind(R.layout.plant_detail_layout);
  }

}
