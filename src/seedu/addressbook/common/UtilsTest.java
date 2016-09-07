package seedu.addressbook.common;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class UtilsTest {

    //@Test no inputs
    public void isAnyNull_noInputs_returnsFalse() {
        assertFalse(Utils.isAnyNull());
    }

    //@Test undefined
    public void isAnyNull_undefined_returnsFalse() {
        int[] inputs = new int[1];
        assertFalse(Utils.isAnyNull(inputs));
    }

    @Test
    public void isAnyNull_noNull_returnsFalse() {
        Object[] inputs = { "hi",'C', new Integer(100), 76};
        assertFalse(Utils.isAnyNull(inputs));
    }

    @Test
    public void isAnyNull_singleNull_returnsTrue() {
        Object[] inputs = { null };
        assertTrue(Utils.isAnyNull(inputs));
    }

    @Test
    public void isAnyNull_multipleNull_returnsTrue() {
        Object[] inputs = { "hello", null, 78, 'r', new Integer(59), null };
        assertTrue(Utils.isAnyNull(inputs));
    }

    /*//@Test no inputs not applicable
    public void elementsAreUnique_noInputs_returnsTrue() {
        assertTrue(Utils.elementsAreUnique());
    }
     */

    //@Test undefined true
    public void elementsAreUnique_undefined_returnsTrue() {
        ArrayList<Object> inputs = new ArrayList<Object>();
        assertTrue(Utils.elementsAreUnique(inputs));
    }

    //@Test undefined false
    public void elementsAreUnique_undefined_returnsFalse() {
        ArrayList<Object> inputs = new ArrayList<Object>();
        assertFalse(Utils.elementsAreUnique(inputs));
    }

    @Test
    public void elementsAreUnique_allUnique_returnsTrue() {
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add("hi, this is not a test");
        inputs.add(new Integer(1234));
        inputs.add('P');
        inputs.add(567);
        inputs.add(null);
        assertTrue(Utils.elementsAreUnique(inputs));
    }

    @Test
    public void elementsAreUnique_oneNotUnique_returnsFalse() {
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add("hi, this is not a test");
        inputs.add(new Integer(1234));
        inputs.add('P');
        inputs.add(567);
        inputs.add(null);
        inputs.add(null);
        assertFalse(Utils.elementsAreUnique(inputs));
    }

    @Test
    public void elementsAreUnique_multipleRepeats_returnsFalse() {
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add("hi, this is not a test");
        inputs.add(new Integer(1234));
        inputs.add('P');
        inputs.add(567);
        inputs.add(null);
        inputs.add(null);
        inputs.add(null);
        inputs.add(new Integer(1234));
        inputs.add('P');
        assertFalse(Utils.elementsAreUnique(inputs));
    }

}
