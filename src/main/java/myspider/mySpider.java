package myspider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class mySpider {
    public static void main(String[] args) {
        new Spider(new MyProcessor()).addUrl("http://news.sina.com.cn/c/2018-09-17/doc-ifxeuwwr5287374.shtml").thread(2).addPipeline(new ConsolePipeline()).runAsync();
    }
}
