package _a_java_model_.design._3_.struct.adapter.demo_springmvc_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  22:46
 * @description :
 */
public class DDispatcherServlet {

    public List<HandlerAdapter> handlerAdapters = new ArrayList<>();


    public DDispatcherServlet() {
        // 放入 handler
        handlerAdapters.add(new SimpHandlerAdapter());
        handlerAdapters.add(new AnnoHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
    }

    public void doDispatcherServlet(){
        // 适配
        AnnoController controller = new AnnoController();

        HandlerAdapter handler = getHandler( controller);
        // 同故宫 适配器
        // 调用 handler 方法//

        // 完成了 扩展
    }

    public HandlerAdapter getHandler(DController dController){
        //然后 遍历 集合 调用 方法 去适配
        //
        for (HandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(dController)){
                return adapter;
            }
        }
        return null;
    }
}
