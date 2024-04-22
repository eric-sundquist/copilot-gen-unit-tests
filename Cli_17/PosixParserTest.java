package org.apache.commons.cli;

import junit.framework.TestCase;

public class PosixParserTest extends TestCase {
    private Options options = null;
    private PosixParser parser = null;

    public void setUp() {
        options = new Options()
            .addOption("a", "enable-a", false, "turn [a] on or off")
            .addOption("b", "bfile", true, "set the value of [b]")
            .addOption("c", "copt", false, "turn [c] on or off");

        parser = new PosixParser();
    }

    public void testSimpleShort() throws Exception {
        String[] args = new String[] { "-a", "-b", "toast", "foo", "bar" };

        CommandLine cl = parser.parse(options, args);

        assertTrue("Confirm -a is set", cl.hasOption("a"));
        assertTrue("Confirm -b is set", cl.hasOption("b"));
        assertTrue("Confirm arg of -b", cl.getOptionValue("b").equals("toast"));
        assertTrue("Confirm size of extra args", cl.getArgList().size() == 2);
    }

    public void testInvalidOption() throws Exception {
        String[] args = new String[] { "-d", "invalid" };

        try {
            CommandLine cl = parser.parse(options, args);
            fail("ParseException was expected");
        } catch (ParseException e) {
            // expected
        }
    }

    public void testMissingOptionArgument() throws Exception {
        String[] args = new String[] { "-b" };

        try {
            CommandLine cl = parser.parse(options, args);
            fail("ParseException was expected");
        } catch (ParseException e) {
            // expected
        }
    }

    public void testStopAtNonOption() throws Exception {
        String[] args = new String[] { "-a", "-d", "non-option", "foo", "bar" };

        CommandLine cl = parser.parse(options, args, true);

        assertTrue("Confirm -a is set", cl.hasOption("a"));
        assertFalse("Confirm -d is not recognized", cl.hasOption("d"));
        assertTrue("Confirm size of extra args", cl.getArgList().size() == 3);
    }

    public void testBurstToken() throws Exception {
        String[] args = new String[] { "-abc", "foo", "bar" };

        CommandLine cl = parser.parse(options, args);

        assertTrue("Confirm -a is set", cl.hasOption("a"));
        assertTrue("Confirm -b is set", cl.hasOption("b"));
        assertTrue("Confirm -c is set", cl.hasOption("c"));
        assertTrue("Confirm size of extra args", cl.getArgList().size() == 2);
    }
}