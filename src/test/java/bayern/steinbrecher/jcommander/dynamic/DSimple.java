package bayern.steinbrecher.jcommander.dynamic;

import bayern.steinbrecher.jcommander.DynamicParameter;

import org.testng.collections.Maps;

import java.util.Map;

public class DSimple {

  @DynamicParameter(names = "-D", description = "Dynamic parameters go here")
  public Map<String, String> params = Maps.newHashMap();

  @DynamicParameter(names = "-A", assignment = "@")
  public Map<String, String> params2 = Maps.newHashMap();
}
