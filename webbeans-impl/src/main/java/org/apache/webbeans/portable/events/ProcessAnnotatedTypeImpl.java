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
package org.apache.webbeans.portable.events;

import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 * Default implementation of the {@link ProcessAnnotatedType}.
 * 
 * @version $Rev$ $Date$
 *
 * @param <X> bean class info
 */
public class ProcessAnnotatedTypeImpl<X> implements ProcessAnnotatedType<X>
{
    /**Annotated Type*/
    private AnnotatedType<X> annotatedType = null;
    
    /**veto or not*/
    private boolean veto = false;
    
    /**set or not*/
    private boolean set = false;

    /**
     * Creates a new instance with the given annotated type.
     * 
     * @param annotatedType annotated type
     */
    public ProcessAnnotatedTypeImpl(AnnotatedType<X> annotatedType)
    {
        this.annotatedType = annotatedType;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public AnnotatedType<X> getAnnotatedType()
    {
        return this.annotatedType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAnnotatedType(AnnotatedType<X> type)
    {
        this.annotatedType = type;
        this.set = true;
    }
    
    /**
     * Returns sets or not.
     * 
     * @return set or not
     */
    public boolean isSet()
    {
        return this.set;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void veto()
    {
        this.veto = true;
    }
    
    /**
     * Returns veto status.
     * 
     * @return veto status
     */
    public boolean isVeto()
    {
        return this.veto;
    }

}