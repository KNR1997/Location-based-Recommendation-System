package Locationbased.Recommendation.System.Neo4j.commons.command;

import java.util.LinkedList;

public abstract class CommandExecutor<T extends ExecutionContext> implements  Command<T>{

    private LinkedList<Command<T>> commands = new LinkedList<>();

    @Override
    public T execute(T context) {
        T cnx = context;

        for (Command<T> command : commands) {
            cnx = command.execute(cnx);
        }
        return cnx;
    }

    public void addCommand(Command<T> command) {
        commands.add(command);
    }

}
