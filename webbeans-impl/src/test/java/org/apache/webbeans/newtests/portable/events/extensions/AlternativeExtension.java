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
package org.apache.webbeans.newtests.portable.events.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

import org.apache.webbeans.newtests.portable.alternative.HalfEgg;


public class AlternativeExtension implements Extension
{
    public void observeProcessAnnotatedType(@Observes ProcessAnnotatedType<HalfEgg> pat)
    {
        // this just works with OWB and assumes a mutable annotation Set.
        pat.getAnnotatedType().getAnnotations().add(new AnnotationLiteral<Alternative>() {});
        pat.setAnnotatedType(pat.getAnnotatedType());
    } 
}
