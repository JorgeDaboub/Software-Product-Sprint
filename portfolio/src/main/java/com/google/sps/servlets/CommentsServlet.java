// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/text")
public final class CommentsServlet extends HttpServlet {

    private List<String> comments;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String text = getParameter(request, "text-input", "");

    // Respond with the result.
    // response.setContentType("text/html;");
    // response.getWriter().println(Arrays.toString(words));

    comments = new ArrayList<>();
    comments.add("Awesome website keep up the good work!. - Sundar Pichai");
    comments.add("I liked your picture. - Maria Sharapova");
    comments.add("Wanna hang out some time? - Jorge Mario Bergoglio");
    comments.add(text);

    String json = convertToJson(comments);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
    }
    
    private String convertToJson(List<String> comments) {
    Gson gson = new Gson();
    String json = gson.toJson(comments);
    return json;
  }

}