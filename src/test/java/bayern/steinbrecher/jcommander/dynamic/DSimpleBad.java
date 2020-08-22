package bayern.steinbrecher.jcommander.dynamic;

import bayern.steinbrecher.jcommander.DynamicParameter;

import java.util.List;

public class DSimpleBad {

  @DynamicParameter(names = "-D")
  public List<String> params;
}
