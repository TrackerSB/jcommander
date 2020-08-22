package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.Parameter;
import bayern.steinbrecher.jcommander.SetConverter;

import java.util.SortedSet;

public class ArgsWithSet {
  @Parameter(names = "-s", converter = SetConverter.class)
  public SortedSet<Integer> set;
}