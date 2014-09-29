package com.itude.mobile.kitchensink.view;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.kitchensink.view.binding.ViewBinder;
import com.itude.mobile.mobbl.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl.core.model.MBElement;
import com.itude.mobile.mobbl.core.model.MBElementContainer;
import com.itude.mobile.mobbl.core.view.MBComponent;
import com.itude.mobile.mobbl.core.view.MBField;

public class ViewBindingController extends MBBasicViewController implements ViewBinder
{

  public View bindView(BuildState state)
  {
    View result = null;
    switch (state.component.getName())
    {
      case "PlantList" :
        result = ListViewBinder.bindView(state);
        break;
      case "Plant" :
        result = bindPlant(state);
        break;
      case "Light" :
        result = bindEditText(state);
        break;
    }

    if (result != null) state.component.attachView(result);

    // process children
    for (MBComponent child : state.component.getChildrenOfKind(MBComponent.class))
    {
      state.component = child;
      Object element = child.getDocument().getValueForPath(child.getAbsoluteDataPath());
      state.element = (MBElementContainer) (element instanceof MBElement ? element : null);
      state.parent = (ViewGroup) (result instanceof ViewGroup ? result : state.parent);

      build(state);
    }

    return result;
  }

  private View bindEditText(BuildState state)
  {
    class ViewHolder
    {
      MBField boundComponent;
    };

    EditText text = (EditText) state.parent.findViewById(R.id.light);

    ViewHolder viewHolder = null;
    // some overhead because we are potentially recycling this view
    if (text.getTag() != null)
    {
      viewHolder = (ViewHolder) text.getTag();
      text.removeTextChangedListener(viewHolder.boundComponent);
      viewHolder.boundComponent.attachView(null);
    }
    else
    {
      viewHolder = new ViewHolder();
      text.setTag(viewHolder);
    }

    text.setText((CharSequence) state.document.getValueForPath(state.component.getAbsoluteDataPath()));
    text.addTextChangedListener((MBField) state.component);
    viewHolder.boundComponent = (MBField) state.component;

    return text;

  }

  private View bindPlant(BuildState state)
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

  private void build(BuildState state)
  {
    // build for current buildstate
    View boundView = bindView(state);

  }

  @Override
  protected ViewGroup buildInitialView(LayoutInflater inflater)
  {
    ViewGroup result = (ViewGroup) inflater.inflate(R.layout.modern_layout, null);
    getPage().rebuild();
    BuildState state = new BuildState();
    state.parent = result;
    state.element = getPage().getDocument();
    state.component = getPage();
    state.mainViewBinder = this;
    state.context = getActivity();
    state.inflater = inflater;
    state.document = getPage().getDocument();

    build(state);

    return result;
  }

  private static class ListViewBinder
  {
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

    public static View bindView(BuildState state)
    {
      ListView result = (ListView) state.parent.findViewById(android.R.id.list);
      result.setAdapter(new MOBBLListViewAdapter(state));

      return result;
    }
  }

}
