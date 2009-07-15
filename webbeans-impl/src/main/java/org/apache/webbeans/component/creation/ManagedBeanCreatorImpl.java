/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.apache.webbeans.component.creation;

import java.lang.reflect.Constructor;

import org.apache.webbeans.component.ManagedBean;
import org.apache.webbeans.config.DefinitionUtil;
import org.apache.webbeans.config.ManagedBeanConfigurator;
import org.apache.webbeans.util.WebBeansUtil;

/**
 * Implementation of the {@link ManagedBeanCreator}.
 * 
 * @version $Rev$ $Date$
 *
 * @param <T> bean type info
 */
public class ManagedBeanCreatorImpl<T> extends AbstractInjectedTargetBeanCreator<T> implements ManagedBeanCreator<T>
{

    /**
     * Creates a new creator.
     * 
     * @param managedBean managed bean instance
     */
    public ManagedBeanCreatorImpl(ManagedBean<T> managedBean)
    {
        super(managedBean);
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void checkCreateConditions()
    {
        ManagedBeanConfigurator.checkSimpleWebBeanCondition(getBean().getReturnType());
        WebBeansUtil.checkGenericType(getBean());
        
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void defineConstructor()
    {
        if(isDefaultMetaDataProvider())
        {
            Constructor<T> constructor = WebBeansUtil.defineConstructor(getBean().getReturnType());
            getBean().setConstructor(constructor);
            DefinitionUtil.addConstructorInjectionPointMetaData(getBean(), constructor);
        }
        else
        {
            //TODO
        }
    }

    /**
     * {@inheritDoc}
     */
    public ManagedBean<T> getBean()
    {
        return (ManagedBean<T>)super.getBean();
    }
}