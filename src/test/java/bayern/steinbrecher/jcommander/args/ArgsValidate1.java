package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.Parameter;
import bayern.steinbrecher.jcommander.validators.PositiveInteger;

public class ArgsValidate1 {

  @Parameter(names = "-age", validateWith = PositiveInteger.class)
  public Integer age;
}
