package bayern.steinbrecher.jcommander.dynamic;

import bayern.steinbrecher.jcommander.JCommander;
import bayern.steinbrecher.jcommander.ParameterException;
import bayern.steinbrecher.jcommander.internal.Maps;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DynamicParameterTest {

  @Test(expectedExceptions = ParameterException.class)
  public void nonMapShouldThrow() {
    new JCommander(new DSimpleBad()).parse("-D", "a=b", "-D", "c=d");
  }

  @Test(expectedExceptions = ParameterException.class)
  public void wrongSeparatorShouldThrow() {
    DSimple ds = new DSimple();
    new JCommander(ds).parse("-D", "a:b", "-D", "c=d");
  }

  private void simple(String... parameters) {
    DSimple ds = new DSimple();
    new JCommander(ds).parse(parameters);
    Assert.assertEquals(ds.params, Maps.newHashMap("a", "b", "c", "d"));
  }

  public void simpleWithSpaces() {
    simple("-D", "a=b", "-D", "c=d");
  }

  public void simpleWithoutSpaces() {
    simple("-Da=b", "-Dc=d");
  }

  public void usage() {
    DSimple ds = new DSimple();
    JCommander jc = JCommander.newBuilder()
            .addObject(ds)
            .build();
    jc.getUsageFormatter().usage(new StringBuilder());
  }

  public void differentAssignment() {
    DSimple ds = new DSimple();
    new JCommander(ds).parse("-D", "a=b", "-A", "c@d");
    Assert.assertEquals(ds.params, Maps.newHashMap("a", "b"));
    Assert.assertEquals(ds.params2, Maps.newHashMap("c", "d"));
  }

  @Test(enabled = false)
  public static void main(String[] args) {
    DynamicParameterTest dpt = new DynamicParameterTest();
    dpt.simpleWithSpaces();
  }
}
