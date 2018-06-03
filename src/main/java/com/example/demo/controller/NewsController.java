package com.example.demo.controller;

import com.example.demo.bean.jo.NewsJo;
import com.example.demo.bean.jo.PageListJo;
import com.example.demo.bean.jo.ReturnJo;
import com.example.demo.bean.model.NewsModel;
import com.example.demo.bean.model.PageModel;
import com.example.demo.bean.po.NewsPO;
import com.example.demo.dao.INewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/4/27.
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private INewsDao iNewsDao;


    @RequestMapping("/ajax-add-news")
    @ResponseBody
    public Object addNews(NewsModel newsModel) {
        NewsPO po = new NewsPO();
        po.setTitle(newsModel.getTitle());
        po.setAuthor(newsModel.getAuthor());
        po.setContent(newsModel.getContent());

        int id = iNewsDao.addNews(po);
        return new ReturnJo(true, "添加成功", 200, id);
    }

    @RequestMapping("/ajax-update-news")
    @ResponseBody
    public Object updateNews(int id, NewsModel newsModel) {
        iNewsDao.updateNewsByModel(id, newsModel);
        return new ReturnJo(true, "更新成功", 200, "");
    }

    @RequestMapping("/ajax-delete-news")
    @ResponseBody
    public Object deleteNews(int id) {
        iNewsDao.updateNewByStatus(id, 1);
        return new ReturnJo(true, "删除成功", 200, "");
    }

    @RequestMapping("/ajax-recover-news")
    @ResponseBody
    public Object recoverNews(int id) {
        iNewsDao.updateNewByStatus(id, 0);
        return new ReturnJo(true, "恢复成功", 200, "");
    }

    @RequestMapping("/ajax-top-news")
    @ResponseBody
    public Object topNews(int id) {
        iNewsDao.topNew(id);
        return new ReturnJo(true, "置顶成功", 200, "");
    }

    @RequestMapping("/ajax-cancel-top-news")
    @ResponseBody
    public Object noTopNews(int id) {
        iNewsDao.cancelTop(id);
        return new ReturnJo(true, "取消置顶成功", 200, "");
    }

    @RequestMapping("/ajax-news-detail")
    @ResponseBody
    public Object detail(int id) {
        NewsPO po = iNewsDao.getNewsById(id);
        return new ReturnJo(true, "置顶成功", 200, po);
    }

    @RequestMapping("/ajax-get-news-list")
    @ResponseBody
    public Object list(int status, PageModel pageModel) {
        List<NewsJo> newsJos = new ArrayList<>();

        List<NewsPO> topPos = iNewsDao.getTopNews(status);
        List<NewsPO> notTop = iNewsDao.getNotTopNews(status);

        if (topPos != null && topPos.size() > 0)
            for (NewsPO po : topPos) {
                newsJos.add(new NewsJo(po));
            }
        if (notTop != null && notTop.size() > 0)
            for (NewsPO po : notTop) {
                newsJos.add(new NewsJo(po));
            }

        PageListJo<NewsJo> data = new PageListJo<>(pageModel.getPage(), pageModel.getNum(), newsJos);
        data.sortPage();
        return new ReturnJo(true, "查询成功", 200, data);
    }

}
