package com.itude.mobile.kitchensink.view;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

import com.itude.mobile.mobbl2.client.core.controller.MBApplicationController;
import com.itude.mobile.mobbl2.client.core.view.MBComponent;
import com.itude.mobile.mobbl2.client.core.view.MBPanel;
import com.itude.mobile.mobbl2.client.core.view.builders.MBPanelViewBuilder;
import com.itude.mobile.mobbl2.client.core.view.builders.MBPanelViewBuilder.BuildState;
import com.itude.mobile.mobbl2.client.core.view.builders.MBViewBuilder;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListViewBuilder extends MBViewBuilder implements MBPanelViewBuilder.Builder
{

  @Override
  public ViewGroup buildPanel(MBPanel panel, BuildState buildState)
  {
    final Context context = MBApplicationController.getInstance().getBaseContext();

    ListView listView = new ListView(context);
    listView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    Adapter adapter = new Adapter(panel, context, 0);

    ArrayList<MBComponent> children = panel.getChildren();
    adapter.addAll(children);;
    listView.setAdapter(adapter);
    listView.setFastScrollEnabled(true);
    listView.setFastScrollAlwaysVisible(true);
    return listView;
  }

  private static class Adapter extends ArrayAdapter<MBComponent> implements SectionIndexer
  {

    public Adapter(MBPanel container, Context context, int textViewResourceId)
    {
      super(context, textViewResourceId);
      _container = container;
    }

    private final MBPanel  _container;
    private final String[] sections = {"blaat", "fiets"};

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      MBComponent component = getItem(position);
      View view = component.buildView();
      view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
      return view;
    }

    @Override
    public Object[] getSections()
    {
      return sections;
    }

    @Override
    public int getPositionForSection(int section)
    {

      return section == 0 ? 0 : 10;
    }

    @Override
    public int getSectionForPosition(int position)
    {

      return position >= 10 ? 1 : 0;
    }

  }

}
