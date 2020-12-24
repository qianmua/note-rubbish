package _a_java_model_.design._Intercepting_filter_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:35
 * @description :
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }

        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
