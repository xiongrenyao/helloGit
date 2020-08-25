package com.xry.git.thread;

import java.util.concurrent.*;

public class DownPic2 implements Callable<Boolean> {

    private String url;
    private String name;

    public DownPic2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDown webDown = new WebDown();
        webDown.downloder(url,name);
        System.out.println("下载的文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DownPic d1 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a1.jpg");
        DownPic d2 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a2.jpg");
        DownPic d3 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a3.jpg");

        //创建执行服务
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = (Future<Boolean>) pool.submit(d1);
        Future<Boolean> r2 = (Future<Boolean>) pool.submit(d2);
        Future<Boolean> r3 = (Future<Boolean>) pool.submit(d3);
        //获取结果
        Boolean b1 = r1.get();
        Boolean b2 = r3.get();
        Boolean b3 = r2.get();
        //关闭服务
        pool.shutdownNow();
    }
}
