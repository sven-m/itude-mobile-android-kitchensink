package com.itude.mobile.kitchensink.view;

import android.view.View;

import com.itude.mobile.mobbl2.client.core.view.MBField;
import com.itude.mobile.mobbl2.client.core.view.builders.MBFieldViewBuilder;
import com.itude.mobile.mobbl2.client.core.view.builders.MBViewBuilder;

// fields of this type aren't added to the view; they only function as markers to be picked up by the ListViewBuilder
public class SectionMarkerFieldViewBuilder extends MBViewBuilder implements MBFieldViewBuilder.Builder
{
  public static final String TYPE = "SECTION-MARKER";

  @Override
  public View buildField(MBField field)
  {
    return null;
  }

}
