package Locationbased.Recommendation.System.Neo4j.commons.command;

import java.util.HashMap;
import java.util.Map;

public abstract class ExecutionContext {

    protected Map<String, Object> contextParam = new HashMap<>();

    protected void putParam(String paramKey, Object paramVal) {contextParam.put(paramKey, paramVal)};

    protected <T> T getParam(String paramKey) {
        T param = (T) contextParam.get(paramKey);
        return param;
    }
}
