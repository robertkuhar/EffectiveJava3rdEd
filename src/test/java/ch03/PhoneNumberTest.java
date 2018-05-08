package ch03;

import com.google.common.collect.Comparators;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.testing.EqualsTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PhoneNumberTest {

    private static PhoneNumber A = new PhoneNumber("206", "903", "0457");
    private static PhoneNumber B = new PhoneNumber(A.getAreaCode(), A.getPrefix(), "0458");
    private static PhoneNumber C = new PhoneNumber(A.getAreaCode(), "904", A.getLineNum());
    private static PhoneNumber D = new PhoneNumber("207", A.getPrefix(), A.getLineNum());
    private static PhoneNumber E = new PhoneNumber(null, null, null);

    @Test
    public void testEqualsHashCode() {
        new EqualsTester()
            .addEqualityGroup(A, A.copy())
            .addEqualityGroup(B)
            .addEqualityGroup(C)
            .addEqualityGroup(D)
            .addEqualityGroup(E)
            .testEquals();
    }

    @Test
    public void testCompareTo() {
        List<PhoneNumber> ordered = Lists.newArrayList(A, A, B, C, D, E);
        Assert.assertTrue(Comparators.isInOrder(ordered, Ordering.natural()));
    }
}
