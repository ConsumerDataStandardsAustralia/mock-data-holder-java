package au.org.consumerdatastandards.client.cli;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.commands.Quit;

@ShellComponent
public class ExitCommand implements Quit.Command {

    @ShellMethod(value = "Exit Client CLI.", key = {"quit", "exit"})
    public void exit() {
        System.exit(0);
    }
}
