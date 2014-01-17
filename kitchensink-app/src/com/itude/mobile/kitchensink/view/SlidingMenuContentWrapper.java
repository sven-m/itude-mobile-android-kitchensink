package com.itude.mobile.kitchensink.view;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.itude.mobile.mobbl.core.controller.MBViewManager;
import com.itude.mobile.mobbl.core.view.builders.MBContentViewWrapper;

public class SlidingMenuContentWrapper implements MBContentViewWrapper
{

  @Override
  public View buildContentView(MBViewManager viewManager, int emplacementId)
  {
    LayoutParams layout = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

    DrawerLayout wrapper = new DrawerLayout(viewManager);

    FrameLayout container = new FrameLayout(viewManager);

    container.setId(emplacementId);

    LayoutParams drawerLayout = new LayoutParams(480, LayoutParams.MATCH_PARENT, GravityCompat.START);
    ListView drawer = new ListView(viewManager);

    drawer.setBackgroundColor(viewManager.getResources().getColor(android.R.color.holo_green_light));

    wrapper.addView(container, layout);
    wrapper.addView(drawer, drawerLayout);

    return wrapper;

    /*    DrawerLayout drawer = (DrawerLayout) viewManager.getLayoutInflater().inflate(R.layout.main, null);

        View content = drawer.findViewById(R.id.content_frame);
        content.setId(emplacementId);
        return drawer;*/
  }
}
