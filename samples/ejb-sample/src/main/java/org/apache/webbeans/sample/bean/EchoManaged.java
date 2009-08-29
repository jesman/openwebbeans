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
package org.apache.webbeans.sample.bean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Current;
import javax.inject.Named;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.webbeans.container.BeanManagerImpl;
import org.apache.webbeans.sample.ejb.Echo;
import org.apache.webbeans.sample.injection.InjectionTargetBean;


@RequestScoped
@Named("echo")
public class EchoManaged
{
    private @Current Echo echo;
        
    private String text;
    
    private String name;
    
    private @Produces @Current @PersistenceUnit(unitName="myDataBase") EntityManagerFactory emf;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String echo()
    {
        BeanManagerImpl manager = BeanManagerImpl.getManager();
        Bean<?> b = manager.getBeans("injected").iterator().next();
        InjectionTargetBean bean = (InjectionTargetBean)manager.getReference(b, InjectionTargetBean.class, manager.createCreationalContext(b)); 
        
        System.out.println("EMF --> " + bean.getFactory().equals(this.emf));
        
        this.text = echo.echo(name);
        
        return null;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
    
    
}