package com.xry.git.thread;

public class DownPic extends Thread {

    private String url;
    private String name;

    public DownPic(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDown webDown = new WebDown();
        webDown.downloder(url,name);
        System.out.println("图片"+name+"下载完成！");
    }

    public static void main(String[] args) {
        DownPic d1 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a1.jpg");
        DownPic d2 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a2.jpg");
        DownPic d3 = new DownPic("http://tiebapic.baidu.com/forum/w%3D580%3B/sign=6ef32ffd1d7b02080cc93fe952e2f0d3/6a63f6246b600c3387b1d9900d4c510fd8f9a199.jpg", "a3.jpg");

        d1.start();
        d2.start();
        d3.start();
    }


}
