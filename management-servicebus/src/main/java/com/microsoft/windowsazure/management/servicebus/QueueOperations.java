/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.servicebus;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusConnectionDetailsResponse;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusQueue;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusQueueCreateParameters;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusQueueResponse;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusQueuesResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Future;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
* The Service Bus Management API includes operations for managing Service Bus
* queues.
*/
public interface QueueOperations {
    /**
    * Creates a new queue. Once created, this queue's resource manifest is
    * immutable. This operation is idempotent. Repeating the create call,
    * after a queue with same name has been created successfully, will result
    * in a 409 Conflict error message.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj856295.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queue Required. The service bus queue.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A response to a request for a particular queue.
    */
    ServiceBusQueueResponse create(String namespaceName, ServiceBusQueueCreateParameters queue) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException, URISyntaxException;
    
    /**
    * Creates a new queue. Once created, this queue's resource manifest is
    * immutable. This operation is idempotent. Repeating the create call,
    * after a queue with same name has been created successfully, will result
    * in a 409 Conflict error message.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj856295.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queue Required. The service bus queue.
    * @return A response to a request for a particular queue.
    */
    Future<ServiceBusQueueResponse> createAsync(String namespaceName, ServiceBusQueueCreateParameters queue);
    
    /**
    * Deletes an existing queue. This operation will also remove all associated
    * state including messages in the queue.  (see
    * http://msdn.microsoft.com/en-us/library/hh780747.aspx for more
    * information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse delete(String namespaceName, String queueName) throws IOException, ServiceException;
    
    /**
    * Deletes an existing queue. This operation will also remove all associated
    * state including messages in the queue.  (see
    * http://msdn.microsoft.com/en-us/library/hh780747.aspx for more
    * information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> deleteAsync(String namespaceName, String queueName);
    
    /**
    * The queue description is an XML AtomPub document that defines the desired
    * semantics for a subscription. The queue description contains the
    * following properties. For more information, see the QueueDescription
    * Properties topic.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780773.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A response to a request for a particular queue.
    */
    ServiceBusQueueResponse get(String namespaceName, String queueName) throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The queue description is an XML AtomPub document that defines the desired
    * semantics for a subscription. The queue description contains the
    * following properties. For more information, see the QueueDescription
    * Properties topic.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780773.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @return A response to a request for a particular queue.
    */
    Future<ServiceBusQueueResponse> getAsync(String namespaceName, String queueName);
    
    /**
    * Gets the set of connection strings for a queue.
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The set of connection details for a service bus entity.
    */
    ServiceBusConnectionDetailsResponse getConnectionDetails(String namespaceName, String queueName) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * Gets the set of connection strings for a queue.
    *
    * @param namespaceName Required. The namespace name.
    * @param queueName Required. The queue name.
    * @return The set of connection details for a service bus entity.
    */
    Future<ServiceBusConnectionDetailsResponse> getConnectionDetailsAsync(String namespaceName, String queueName);
    
    /**
    * Enumerates the queues in the service namespace. The result is returned in
    * pages, each containing up to 100 queues. If the namespace contains more
    * than 100 queues, a feed is returned that contains the first page and a
    * next link with the URI to view the next page of data.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780759.asp for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A response to a request for a list of queues.
    */
    ServiceBusQueuesResponse list(String namespaceName) throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * Enumerates the queues in the service namespace. The result is returned in
    * pages, each containing up to 100 queues. If the namespace contains more
    * than 100 queues, a feed is returned that contains the first page and a
    * next link with the URI to view the next page of data.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780759.asp for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @return A response to a request for a list of queues.
    */
    Future<ServiceBusQueuesResponse> listAsync(String namespaceName);
    
    /**
    * Updates the queue description and makes a call to update corresponding DB
    * entries.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj856305.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queue Required. The service bus queue.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A response to a request for a particular queue.
    */
    ServiceBusQueueResponse update(String namespaceName, ServiceBusQueue queue) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException;
    
    /**
    * Updates the queue description and makes a call to update corresponding DB
    * entries.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj856305.aspx for
    * more information)
    *
    * @param namespaceName Required. The namespace name.
    * @param queue Required. The service bus queue.
    * @return A response to a request for a particular queue.
    */
    Future<ServiceBusQueueResponse> updateAsync(String namespaceName, ServiceBusQueue queue);
}
