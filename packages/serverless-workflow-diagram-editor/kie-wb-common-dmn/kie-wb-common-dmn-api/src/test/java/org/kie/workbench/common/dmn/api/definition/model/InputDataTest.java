/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.dmn.api.definition.model;

import org.junit.Test;
import org.kie.workbench.common.dmn.api.property.dimensions.GeneralRectangleDimensionsSet;
import org.kie.workbench.common.dmn.api.property.dmn.Description;
import org.kie.workbench.common.dmn.api.property.dmn.Id;
import org.kie.workbench.common.dmn.api.property.dmn.Name;
import org.kie.workbench.common.dmn.api.property.dmn.QName;
import org.kie.workbench.common.dmn.api.property.styling.FontSize;
import org.kie.workbench.common.dmn.api.property.styling.StylingSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

public class InputDataTest {

    @Test
    public void testConstructor() {
        final Id id = mock(Id.class);
        final Description description = mock(Description.class);
        final Name name = mock(Name.class);
        final StylingSet stylingSet = mock(StylingSet.class);
        final GeneralRectangleDimensionsSet dimensionsSet = mock(GeneralRectangleDimensionsSet.class);

        final InformationItemPrimary variable = new InformationItemPrimary();
        final InputData expectedParent = new InputData(id,
                                                       description,
                                                       name,
                                                       variable,
                                                       stylingSet,
                                                       dimensionsSet);

        final DMNModelInstrumentedBase actualParent = variable.getParent();

        assertEquals(expectedParent, actualParent);
    }

    @Test
    public void testDifferentStylingSet() {

        final InputData modelOne = new InputData(new Id("123"),
                                                 new Description(),
                                                 new Name(),
                                                 new InformationItemPrimary(new Id("346"),
                                                                            new Name(),
                                                                            new QName()),
                                                 new StylingSet(),
                                                 new GeneralRectangleDimensionsSet());

        final InputData modelTwo = new InputData(new Id("123"),
                                                 new Description(),
                                                 new Name(),
                                                 new InformationItemPrimary(new Id("346"),
                                                                            new Name(),
                                                                            new QName()),
                                                 new StylingSet(),
                                                 new GeneralRectangleDimensionsSet());

        assertEquals(modelOne, modelTwo);

        modelOne.getStylingSet().setFontSize(new FontSize(10.0));
        modelTwo.getStylingSet().setFontSize(new FontSize(11.0));

        assertNotEquals(modelOne, modelTwo);
    }
}
