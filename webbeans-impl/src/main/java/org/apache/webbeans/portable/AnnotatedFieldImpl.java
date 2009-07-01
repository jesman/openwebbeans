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
package org.apache.webbeans.portable;

import java.lang.reflect.Field;

import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedType;

/**
 * Implementation of {@link AnnotatedField} interface.
 * 
 * @version $Rev$ $Date$
 *
 * @param <X>
 */
public class AnnotatedFieldImpl<X> extends AbstractAnnotatedMember<X> implements AnnotatedField<X>
{

    /**
     * Creates a new instance
     * 
     * @param baseType base type
     * @param javaMember field
     */
    AnnotatedFieldImpl(Field javaMember)
    {
        this(javaMember, null);
    }    
    
    /**
     * Creates a new instance
     * 
     * @param baseType base type
     * @param javaMember field
     */
    AnnotatedFieldImpl(Field javaMember, AnnotatedType<X> declaringType)
    {
        super(javaMember.getGenericType(), javaMember,declaringType);
        
        setAnnotations(javaMember.getDeclaredAnnotations());
    }
    

    /**
     * {@inheritDoc}
     */
    public Field getJavaMember()
    {
        return Field.class.cast(this.javaMember);
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Annotated Field,");
        builder.append(super.toString());
        
        return builder.toString();
    }
    
}