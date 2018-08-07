package cn.itheima.web.servlet1;

public class MyServletImpl_002 implements IMyServlet{


    @Override
    public void destory() {
        System.out.println("啊,俺来也....");
    }

    @Override
    public void init() {
        System.out.println("我可以为你服务了....");
    }

    @Override
    public void service() {
        System.out.println("啊,俺去也....");
    }
}
