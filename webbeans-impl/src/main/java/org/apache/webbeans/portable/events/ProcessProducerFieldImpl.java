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

import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.ProcessProducerField;

import org.apache.webbeans.component.ProducerFieldBean;

/**
 * Implementation of the {@link ProcessProducerField}.
 * 
 * @version $Rev$ $Date$
 *
 * @param <X> declared bean class
 * @param <T> producer return type info
 */
public class ProcessProducerFieldImpl<X,T> extends ProcessBeanImpl<T> implements ProcessProducerField<X, T>
{
    /**Annotated field*/
    private final AnnotatedField<X> annotatedField;

    public ProcessProducerFieldImpl(ProducerFieldBean<T> bean, AnnotatedField<X> annotatedField)
    {
        super(bean, annotatedField);
        this.annotatedField = annotatedField;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public AnnotatedField<X> getAnnotatedProducerField()
    {
        return this.annotatedField;
    }
    
}