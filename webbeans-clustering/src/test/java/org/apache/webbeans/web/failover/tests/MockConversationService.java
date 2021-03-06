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

import javax.enterprise.context.Conversation;
import javax.servlet.http.HttpSession;

import org.apache.webbeans.spi.ConversationService;

public class MockConversationService implements ConversationService
{
    private String conversationId;
    private String sessionId;

    public MockConversationService(HttpSession session, Conversation conversation)
    {
        this.sessionId = session.getId();
        this.conversationId = conversation.getId();
    }

    public String getConversationId()
    {
        return conversationId;
    }

    public String getConversationSessionId()
    {
        return sessionId;
    }
}
