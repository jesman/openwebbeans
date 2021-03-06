/*
 * Copyright 2012 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.webbeans.newtests.injection.injectionpoint.beans;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class InjectionPointBeansOwner {

    @Inject
    private ConstructorInjectionPointOwner constructorInjection;
    @Inject
    private FieldInjectionPointOwner fieldInjection;
    @Inject
    private MethodInjectionPointOwner methodInjection;
    @Inject
    private Instance<ConstructorInjectionPointOwner> constructorInjectionInstance;
    @Inject
    private Instance<FieldInjectionPointOwner> fieldInjectionInstance;
    @Inject
    private Instance<MethodInjectionPointOwner> methodInjectionInstance;
    @Inject
    private Event<StringBuilder> observerInjection;
    
    public String getConstructorInjectionName() {
        return constructorInjection.getName();
    }
    
    public String getFieldInjectionName() {
        return fieldInjection.getName();
    }
    
    public String getMethodInjectionName() {
        return methodInjection.getName();
    }
    
    public String getConstructorInjectionInstanceName() {
        return constructorInjectionInstance.get().getName();
    }
    
    public String getFieldInjectionInstanceName() {
        return fieldInjectionInstance.get().getName();
    }
    
    public String getMethodInjectionInstanceName() {
        return methodInjectionInstance.get().getName();
    }

    public String getObserverInjectionName() {
        StringBuilder name = new StringBuilder();
        observerInjection.fire(name);
        return name.toString();
    }
}
