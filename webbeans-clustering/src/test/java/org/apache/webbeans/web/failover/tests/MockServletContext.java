/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.web.failover.tests;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
 */
public class MockServletContext implements ServletContext
{
    public Object getAttribute(String name)
    {
        return null;
    }

    public ServletContext getContext(String uripath)
    {
        return null;
    }

    public String getContextPath()
    {
        return null;
    }

    public int getMajorVersion()
    {
        return 0;
    }

    public int getMinorVersion()
    {
        return 0;
    }

    public String getMimeType(String file)
    {
        return null;
    }

    public Set getResourcePaths(String path)
    {
        return null;
    }

    public URL getResource(String path) throws MalformedURLException
    {
        return null;
    }

    public InputStream getResourceAsStream(String path)
    {
        return null;
    }

    public RequestDispatcher getRequestDispatcher(String path)
    {
        return null;
    }

    public RequestDispatcher getNamedDispatcher(String name)
    {
        return null;
    }

    public Servlet getServlet(String name) throws ServletException
    {
        return null;
    }

    public Enumeration getServlets()
    {
        return null;
    }

    public Enumeration getServletNames()
    {
        return null;
    }

    public void log(String msg)
    {
    }

    public void log(Exception exception, String msg)
    {
    }

    public void log(String message, Throwable throwable)
    {
    }

    public String getRealPath(String path)
    {
        return null;
    }

    public String getServerInfo()
    {
        return null;
    }

    public String getInitParameter(String name)
    {
        return null;
    }

    public Enumeration getInitParameterNames()
    {
        return null;
    }

    public Enumeration getAttributeNames()
    {
        return null;
    }

    public void setAttribute(String name, Object object)
    {
    }

    public void removeAttribute(String name)
    {
    }

    public String getServletContextName()
    {
        return null;
    }
}
