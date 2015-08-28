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

package org.apache.ranger.plugin.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE, setterVisibility= JsonAutoDetect.Visibility.NONE, fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL )
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class RangerServiceResource extends RangerBaseModelObject {
	private static final long serialVersionUID = 1L;

	private String                                         serviceName  = null;
	private Map<String, RangerPolicy.RangerPolicyResource> resourceSpec = null;
	private String resourceSignature = null;


	public RangerServiceResource(String guid, String serviceName, Map<String, RangerPolicy.RangerPolicyResource> resourceSpec, String resourceSignature) {
		super();
		setGuid(guid);
		setServiceName(serviceName);
		setResourceSpec(resourceSpec);
		setResourceSignature(resourceSignature);
	}
	public RangerServiceResource(String guid, String serviceName, Map<String, RangerPolicy.RangerPolicyResource> resourceSpec) {
		this(guid, serviceName, resourceSpec, null);
	}
	public RangerServiceResource(String serviceName, Map<String, RangerPolicy.RangerPolicyResource> resourceSpec) {
		this(null, serviceName, resourceSpec, null);
	}

	public RangerServiceResource() {
		this(null, null, null, null);
	}

	public String getServiceName() { return serviceName; }

	public Map<String, RangerPolicy.RangerPolicyResource> getResourceSpec() { return resourceSpec; }

	public String getResourceSignature() {
		return resourceSignature;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setResourceSpec(Map<String, RangerPolicy.RangerPolicyResource> resourceSpec) {
		this.resourceSpec = resourceSpec == null ? new HashMap<String, RangerPolicy.RangerPolicyResource>() : resourceSpec;
	}

	public void setResourceSignature(String resourceSignature) {
		this.resourceSignature = resourceSignature;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		toString(sb);

		return sb.toString();
	}

	public StringBuilder toString(StringBuilder sb) {

		sb.append("{ ");

		sb.append("guid={").append(getGuid()).append("} ");
		sb.append("serviceName={").append(serviceName).append("} ");

		sb.append("resourceSpec={");
		if(resourceSpec != null) {
			for(Map.Entry<String, RangerPolicy.RangerPolicyResource> e : resourceSpec.entrySet()) {
				sb.append(e.getKey()).append("={");
				e.getValue().toString(sb);
				sb.append("} ");
			}
		}
		sb.append("} ");

		sb.append("resourceSignature={").append(resourceSignature).append("} ");

		sb.append(" }");

		return sb;
	}
}

