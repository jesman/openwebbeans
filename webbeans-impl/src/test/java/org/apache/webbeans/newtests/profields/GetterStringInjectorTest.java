/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.newtests.profields;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.inject.spi.Bean;

import junit.framework.Assert;

import org.apache.webbeans.newtests.AbstractUnitTest;
import org.apache.webbeans.newtests.profields.beans.GetterStringFieldInjector;
import org.apache.webbeans.newtests.profields.beans.GetterStringProducerBean;
import org.junit.Test;

public class GetterStringInjectorTest extends AbstractUnitTest
{
    @Test
    @SuppressWarnings("unchecked")
    public void testGetterStringInjector()
    {
        Collection<URL> beanXmls = new ArrayList<URL>();
        
        Collection<Class<?>> beanClasses = new ArrayList<Class<?>>();
        beanClasses.add(GetterStringProducerBean.class);
        beanClasses.add(GetterStringFieldInjector.class);
        
        startContainer(beanClasses, beanXmls);   
        
        Bean<GetterStringFieldInjector> bean = (Bean<GetterStringFieldInjector>) getBeanManager().getBeans("org.apache.webbeans.newtests.profields.beans.GetterStringFieldInjector").iterator().next();
        GetterStringFieldInjector injector = (GetterStringFieldInjector) getBeanManager().getReference(bean, GetterStringFieldInjector.class, getBeanManager().createCreationalContext(bean));
        
        Assert.assertEquals("Sucess from getProducts",injector.getTestNamed3());
        
        shutDownContainer();
    }
    

}