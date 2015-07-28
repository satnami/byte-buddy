package net.bytebuddy.dynamic.scaffold;

import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.test.utility.MockitoRule;
import net.bytebuddy.test.utility.ObjectPropertyAssertion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FieldRegistryCompiledNoOpTest {

    @Rule
    public TestRule mockitoRule = new MockitoRule(this);

    @Mock
    private FieldDescription fieldDescription;

    @Test
    public void testReturnsNoOp() throws Exception {
        TypeWriter.FieldPool.Entry entry = FieldRegistry.Compiled.NoOp.INSTANCE.target(fieldDescription);
        assertThat(entry.getDefaultValue(), is(FieldDescription.NO_DEFAULT_VALUE));
        assertThat(entry.getFieldAppender(), is((FieldAttributeAppender) FieldAttributeAppender.NoOp.INSTANCE));
    }

    @Test
    public void testObjectProperties() throws Exception {
        ObjectPropertyAssertion.of(FieldRegistry.Compiled.NoOp.class).apply();
    }
}