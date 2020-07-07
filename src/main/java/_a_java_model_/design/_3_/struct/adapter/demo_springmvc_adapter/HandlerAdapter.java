package _a_java_model_.design._3_.struct.adapter.demo_springmvc_adapter;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  22:46
 * @description :
 */
interface HandlerAdapter {

    /**
     * 适配
     * @param o
     * @return
     */
    boolean supports(Object o);
}

class SimpHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object o) {
        return o instanceof SimpController;
    }
}
class HttpHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object o) {
        return o instanceof HttpController;
    }
}
class AnnoHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object o) {
        return o instanceof AnnoController;
    }
}
