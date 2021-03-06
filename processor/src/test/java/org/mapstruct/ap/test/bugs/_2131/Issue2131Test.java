/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.bugs._2131;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Filip Hrisafov
 */
@IssueKey("2131")
@RunWith(AnnotationProcessorTestRunner.class)
@WithClasses(Issue2131Mapper.class)
public class Issue2131Test {

    @Test
    public void shouldCompile() {
        Issue2131Mapper mapper = Issue2131Mapper.INSTANCE;

        Issue2131Mapper.TestDto target = mapper.map( new Issue2131Mapper.TestModel( "test" ) );

        assertThat( target ).isNotNull();
        assertThat( target.getName() ).isEqualTo( "test" );

        target = mapper.map( new Issue2131Mapper.TestModel( null ) );
        assertThat( target ).isNotNull();
        assertThat( target.getName() ).isNull();
    }
}
