package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.Parameter;

public class Arity1
{
  @Parameter(arity = 1, names = "-inspect", description = "", required = false)
  public boolean inspect;
}
