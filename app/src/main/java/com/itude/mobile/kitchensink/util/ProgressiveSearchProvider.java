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
package com.itude.mobile.kitchensink.util;

import java.util.List;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;

import com.itude.mobile.mobbl.core.model.MBDocument;
import com.itude.mobile.mobbl.core.model.MBElement;
import com.itude.mobile.mobbl.core.services.MBDataManagerService;

public class ProgressiveSearchProvider extends ContentProvider
{
  private static final String[] CHILDREN_OF_PLANT_ELEMENT = new String[]{"COMMON", "BOTANICAL", "ZONE", "LIGHT", "PRICE", "AVAILABILITY"};

  @Override
  public boolean onCreate()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
  {
    String query = uri.getLastPathSegment().toLowerCase();
    if (query.equals(SearchManager.SUGGEST_URI_PATH_QUERY)) return null;

    MBDocument dataSource = MBDataManagerService.getInstance().loadDocument("CATALOG");

    List<MBElement> plantElements = dataSource.getValueForPath("/PLANT");

    MatrixCursor result = new MatrixCursor(new String[]{BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1,
        SearchManager.SUGGEST_COLUMN_TEXT_2, SearchManager.SUGGEST_COLUMN_INTENT_DATA, SearchManager.SUGGEST_COLUMN_SHORTCUT_ID,
        SearchManager.SUGGEST_COLUMN_QUERY});

    int idx = 0;
    for (MBElement plantElement : plantElements)
    {
      for (String childOfPlantElement : CHILDREN_OF_PLANT_ELEMENT)
      {
        String suggestColumnText1 = plantElement.getValueForPath("/" + childOfPlantElement + "[0]/@text()");

        if (suggestColumnText1.contains(query))
        {
          String suggestColumnText2 = plantElement.getValueForPath("/COMMON[0]/@text()");
          int indexOfPlant = plantElements.indexOf(plantElement);
          String columnId = String.valueOf(indexOfPlant);
          String suggestColumnIntentData = "/PLANT[" + idx++ + "]";
          result.addRow(new String[]{columnId, suggestColumnText1, suggestColumnText2, suggestColumnIntentData,
              SearchManager.SUGGEST_NEVER_MAKE_SHORTCUT, query});

          // process next plant element
          break; // inner for-loop
        }
      }
    }

    return result;
  }

  @Override
  public String getType(Uri uri)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Uri insert(Uri uri, ContentValues values)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete(Uri uri, String selection, String[] selectionArgs)
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
