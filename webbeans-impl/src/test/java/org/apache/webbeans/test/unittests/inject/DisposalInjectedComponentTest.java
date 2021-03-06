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
package org.apache.webbeans.test.unittests.inject;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;

import org.apache.webbeans.newtests.AbstractUnitTest;
import org.apache.webbeans.test.component.DisposalMethodComponent;
import org.apache.webbeans.test.component.service.IService;
import org.apache.webbeans.test.component.service.ServiceImpl1;
import org.junit.Test;

public class DisposalInjectedComponentTest extends AbstractUnitTest
{

    @Test
    public void testTypedComponent() throws Throwable
    {
        Collection<Class<?>> classes = new ArrayList<Class<?>>();
        classes.add(DisposalMethodComponent.class);
        classes.add(ServiceImpl1.class);

        startContainer(classes, null);


        IService producedService = getInstance("service");
        
        Assert.assertNotNull(producedService);
        
        IService service = getInstance(IService.class);

        Assert.assertEquals("ServiceImpl1", service.service());

        DisposalMethodComponent mc = getInstance(DisposalMethodComponent.class);

        IService s = mc.service();

        Assert.assertNotNull(s);


        shutDownContainer();
    }

}
