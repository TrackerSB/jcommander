package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.Parameter;
import bayern.steinbrecher.jcommander.Parameters;

@Parameters(separators = "=")
public class ArgsEquals {

  @Parameter(names = "-args")
  public String args;
}
