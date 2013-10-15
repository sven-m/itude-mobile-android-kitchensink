/*
 * (C) Copyright ItudeMobile.
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
package com.itude.mobile.kitchensink.services;

import org.apache.http.client.methods.HttpUriRequest;

import com.itude.mobile.mobbl2.client.core.model.MBDocumentFactory;
import com.itude.mobile.mobbl2.client.core.services.datamanager.handlers.MBRESTServiceDataHandler;

public class OAuthRestServiceDataHandler extends MBRESTServiceDataHandler
{

  public OAuthRestServiceDataHandler()
  {
    setDocumentFactoryType(MBDocumentFactory.PARSER_XML);
  }

  @Override
  protected void setupHttpUriRequestHeader(HttpUriRequest httpUriRequest)
  {
    super.setupHttpUriRequestHeader(httpUriRequest);

    httpUriRequest.addHeader("Authorization", "Bearer 7d0a194c-3773-48be-8761-e7e353d37d4f");
  }

}
