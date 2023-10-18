package Locationbased.Recommendation.System.Neo4j.commons.command;

public interface Command <T extends ExecutionContext>{

    public T execute(T context);
}
