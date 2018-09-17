package myspider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class MyProcessor implements PageProcessor {
    private Site site = Site.me().addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36").setCharset("utf-8").setSleepTime(100).setRetryTimes(1);

    @Override
    public void process(Page page) {
        List<String> title = page.getHtml().xpath("//h1[@class='main-title']/text()").all();
        List<String> time = page.getHtml().xpath("//*[@id=\"top_bar\"]/div/div[2]/span/text()").all();
        List<String> context = page.getHtml().xpath("//*[@id=\"article\"]").all();

        for(int i = 0; i < title.size(); i++){
            System.out.println("title------>" + title.get(i));
            System.out.println("time------>" + time.get(i));
            System.out.println("context------>" + context.get(i));
        }


    }

    //站点信息
    @Override
    public Site getSite() {
        return site;
    }
}
