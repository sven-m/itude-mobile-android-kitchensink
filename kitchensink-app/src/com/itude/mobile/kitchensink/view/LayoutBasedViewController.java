package com.itude.mobile.kitchensink.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.itude.mobile.kitchensink.R;
import com.itude.mobile.mobbl2.client.core.controller.util.MBBasicViewController;
import com.itude.mobile.mobbl2.client.core.services.MBDataManagerService;
import com.itude.mobile.mobbl2.client.core.view.MBField;

public class LayoutBasedViewController extends MBBasicViewController
{
  private TextView _label;
  private Button   _button;
  private EditText _text;

  private MBField  _labelField;
  private MBField  _buttonField;

  @Override
  protected ViewGroup buildInitialView()
  {
    LayoutInflater inflater = getLayoutInflater(null);
    ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout_based_view, null);

    _labelField = (MBField) getPage().getFirstDescendantOfKindWithName(MBField.class, "inputfield");
    String labelText = _labelField.getLabel();
    _label = (TextView) view.findViewById(R.id.label);
    _label.setText(labelText);

    _buttonField = (MBField) getPage().getFirstDescendantOfKindWithName(MBField.class, "button");
    String buttonText = _buttonField.getLabel();
    _button = (Button) view.findViewById(R.id.button);
    _button.setText(buttonText);
    _button.setOnClickListener(new OnClickListener()
    {

      @Override
      public void onClick(View v)
      {
        _labelField.setValue(_text.getText().toString());
        MBDataManagerService.getInstance().storeDocument(getPage().getDocument());
        rebuildView(true);
      }
    });

    _text = (EditText) view.findViewById(R.id.text);

    return view;
  }

}
