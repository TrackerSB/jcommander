package bayern.steinbrecher.jcommander.args;

import bayern.steinbrecher.jcommander.Parameter;
import bayern.steinbrecher.jcommander.Parameters;

@Parameters(commandNames = {"command"}, commandDescription = "text text text text text " +
        "text text text text text text text text text text text text text text text " +
        "really-really-really-long-word-or-url text text text text text text text.")
public class ArgsLongCommandDescription {
    @Parameter(names = {"-b"}, description = "boolean parameter")
    public boolean var;
}
