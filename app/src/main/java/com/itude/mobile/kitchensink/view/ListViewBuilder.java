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
package com.itude.mobile.kitchensink.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

import com.itude.mobile.mobbl.core.controller.MBApplicationController;
import com.itude.mobile.mobbl.core.view.MBComponent;
import com.itude.mobile.mobbl.core.view.MBField;
import com.itude.mobile.mobbl.core.view.MBPanel;
import com.itude.mobile.mobbl.core.view.builders.MBPanelViewBuilder;
import com.itude.mobile.mobbl.core.view.builders.MBPanelViewBuilder.BuildState;
import com.itude.mobile.mobbl.core.view.builders.MBViewBuilder;

public class ListViewBuilder extends MBViewBuilder implements MBPanelViewBuilder.Builder
{

  @Override
  public ViewGroup buildPanel(MBPanel panel, BuildState buildState)
  {
    final Context context = MBApplicationController.getInstance().getBaseContext();

    ListView listView = new ListView(context);
    listView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    Adapter adapter = new Adapter(panel, context, 0);
    List<MBComponent> children = panel.getChildren();
    for (MBComponent child : children)
      adapter.add(child);
    listView.setAdapter(adapter);

    if (adapter.getSections().length > 1)
    {
      listView.setFastScrollEnabled(true);
      //listView.setFastScrollAlwaysVisible(true);
    }
    return listView;
  }

  private static class Adapter extends ArrayAdapter<MBComponent> implements SectionIndexer
  {

    private static class Section
    {
      private final String _name;
      private final int    _startPosition;

      public Section(String name, int startPosition)
      {
        _name = name;
        _startPosition = startPosition;
      }

      public String getName()
      {
        return _name;
      }

      public int getStartPosition()
      {
        return _startPosition;
      }

      @Override
      public String toString()
      {
        return getName();
      }
    }

    public Adapter(MBPanel container, Context context, int textViewResourceId)
    {
      super(context, textViewResourceId);

      setNotifyOnChange(true);
    }

    @Override
    public void notifyDataSetChanged()
    {
      extractSections();
      super.notifyDataSetChanged();
    }

    private void extractSections()
    {
      List<String> sections = new ArrayList<String>(getCount());

      for (int i = 0; i < getCount(); ++i)
      {
        MBComponent component = getItem(i);
        List<MBField> fields = component.getChildrenOfKindWithType(MBField.class, SectionMarkerFieldViewBuilder.TYPE);
        if (!fields.isEmpty())
        {
          MBField field = fields.get(0);
          sections.add(field.getValuesForDisplay());
        }
        else sections.add("");
      }

      int[] mappedSections = new int[getCount()];
      List<Section> consolidatedSections = new ArrayList<Section>(getCount());
      Section previous = null;
      int position = 0;
      for (String section : sections)
      {
        if (previous == null || !previous.getName().equals(section))
        {
          previous = new Section(section, position);
          consolidatedSections.add(previous);
        }
        mappedSections[position] = consolidatedSections.size() - 1;
        position++;
      }

      _sections = consolidatedSections.toArray(new Section[consolidatedSections.size()]);
      _mappedSections = mappedSections;
    }

    private Section[] _sections;
    private int[]     _mappedSections;

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      MBComponent component = getItem(position);
      View view = component.buildView();
      if (view != null) view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
      return view;
    }

    @Override
    public Object[] getSections()
    {
      return _sections;
    }

    @Override
    public int getPositionForSection(int section)
    {
      if (section < 0) return 0;
      if (section >= _sections.length) return getCount() - 1;
      return _sections[section].getStartPosition();
    }

    @Override
    public int getSectionForPosition(int position)
    {
      if (position < 0) return 0;
      if (position >= getCount()) return _sections.length - 1;
      return _mappedSections[position];
    }

  }

}
