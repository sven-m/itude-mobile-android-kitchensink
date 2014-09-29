package com.itude.mobile.kitchensink.view.binding;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itude.mobile.mobbl.core.view.MBComponent;

public class ListViewBinder implements ViewBinder
{
  private final int id;

  protected ListViewBinder(int id)
  {
    this.id = id;
  }

  public static ListViewBinder getInstance(int id)
  {
    return new ListViewBinder(id);
  }

  @Override
  public View bindView(BuildState state)
  {
    ListView result = (ListView) state.parent.findViewById(id);
    result.setAdapter(new MOBBLListViewAdapter(state));
    return result;
  }

  private static class MOBBLListViewAdapter extends ArrayAdapter<MBComponent>
  {

    private BuildState state;

    public MOBBLListViewAdapter(BuildState buildState)
    {
      super(buildState.context, 0);

      state = buildState.clone();

      List<MBComponent> children = buildState.component.getChildrenOfKind(MBComponent.class);

      setNotifyOnChange(false);
      for (MBComponent child : children)
        add(child);

      notifyDataSetChanged();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      BuildState state = this.state.clone();
      state.component = getItem(position);
      state.element = state.component.getDocument().getValueForPath(state.component.getAbsoluteDataPath());
      state.parent = parent;
      state.recycledView = convertView;

      return state.mainViewBinder.bindView(state);
    }

  }

}