/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.dmn.client.property.dmn;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.kie.workbench.common.dmn.api.property.dmn.Name;
import org.kie.workbench.common.dmn.api.property.dmn.NameFieldType;
import org.kie.workbench.common.forms.fields.shared.AbstractFieldDefinition;
import org.kie.workbench.common.forms.model.FieldDefinition;

@Portable
@Bindable
public class NameFieldDefinition extends AbstractFieldDefinition {

    public static final NameFieldType FIELD_TYPE = new NameFieldType();

    public NameFieldDefinition() {
        super(Name.class.getName());
    }

    @Override
    protected void doCopyFrom(final FieldDefinition other) {
        // There's nothing to copy.
    }

    @Override
    public NameFieldType getFieldType() {
        return FIELD_TYPE;
    }
}
