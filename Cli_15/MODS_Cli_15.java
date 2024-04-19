
package org.apache.commons.cli2.commandline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;
import org.apache.commons.cli2.Option;
import org.apache.commons.cli2.WriteableCommandLine;

import java.util.ArrayList;

import org.apache.commons.cli2.WriteableCommandLine;
import org.apache.commons.cli2.WriteableCommandLineTestCase;


public class WriteableCommandLineImplTest extends TestCase {
    private WriteableCommandLineImpl commandLine;

    protected void setUp() {
        commandLine = new WriteableCommandLineImpl(root, new ArrayList());
    }

    public void testGetValuesWithNullOptionAndDefaultValues() {
        List result = commandLine.getValues(null, null);
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testGetValuesWithOptionAndNullDefaultValues() {
        Option option = new Option("test", "test option");
        List result = commandLine.getValues(option, null);
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testGetValuesWithOptionAndEmptyDefaultValues() {
        Option option = new Option("test", "test option");
        List result = commandLine.getValues(option, new ArrayList());
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testGetValuesWithOptionAndNonEmptyDefaultValues() {
        Option option = new Option("test", "test option");
        List defaultValues = Arrays.asList("default1", "default2");
        List result = commandLine.getValues(option, defaultValues);
        assertEquals(defaultValues, result);
    }

    public void testGetValuesWithOptionAndDefaultValuesMoreThanValues() {
        Option option = new Option("test", "test option");
        commandLine.addValue(option, "value1");
        List defaultValues = Arrays.asList("default1", "default2");
        List result = commandLine.getValues(option, defaultValues);
        assertEquals(Arrays.asList("value1", "default2"), result);
    }

    public void testGetValuesWithOptionAndDefaultValuesLessThanValues() {
        Option option = new Option("test", "test option");
        commandLine.addValue(option, "value1");
        commandLine.addValue(option, "value2");
        List defaultValues = Arrays.asList("default1");
        List result = commandLine.getValues(option, defaultValues);
        assertEquals(Arrays.asList("value1", "value2"), result);
    }
}