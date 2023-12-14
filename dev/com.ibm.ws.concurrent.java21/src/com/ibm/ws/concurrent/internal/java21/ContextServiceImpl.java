/*******************************************************************************
 * Copyright (c) 2012, 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.concurrent.internal.java21;

import java.util.concurrent.Flow;

import org.eclipse.microprofile.context.ThreadContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.ibm.ws.concurrent.internal.ContextServiceBase;
import com.ibm.wsspi.application.lifecycle.ApplicationRecycleComponent;
import com.ibm.wsspi.resource.ResourceFactory;
import com.ibm.wsspi.threadcontext.WSContextService;

import jakarta.enterprise.concurrent.ContextService;

/**
 * Captures and propagates thread context.
 * This class implements the Jakarta/Java EE ContextService as well as MicroProfile ThreadContext.
 */
@Component(name = "com.ibm.ws.context.service",
           configurationPolicy = ConfigurationPolicy.REQUIRE,
           service = { ResourceFactory.class, ContextService.class, ThreadContext.class, WSContextService.class, ApplicationRecycleComponent.class },
           property = { "creates.objectClass=javax.enterprise.concurrent.ContextService",
                        "creates.objectClass=org.eclipse.microprofile.context.ThreadContext" })
public class ContextServiceImpl extends ContextServiceBase implements ContextService {

    public <T> Flow.Subscriber<T> contextualSubscriber(Flow.Subscriber<T> subscriber) {
        throw new UnsupportedOperationException("contextualSubscriber is not implemented");
    }

    public <T, R> Flow.Processor<T, R> contextualProcessor(Flow.Processor<T, R> processor) {
        throw new UnsupportedOperationException("contextualProcessor is not implemented");
    }
}