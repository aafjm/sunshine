package com.example.demo.bean.jo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjiamin on 2018/3/18.
 */
public class PageListJo<T> {
    private int page;
    private int maxPage;
    private int num;
    private List<T> list;

    public PageListJo() {
    }

    public PageListJo(int page, int num, List<T> list) {
        this.page = page;
        this.num = num;
        this.list = list;
    }

    // 切割
    public void sortPage() {
        int size = list.size();
        if (size % num == 0) {
            maxPage = size / num;
        } else {
            maxPage = size / num + 1;
        }
        int maxNum = page * num;
        int minNum = page * num - num -1;

        List<T> cutList = new ArrayList<>();
        if (size > minNum) {
            for (int i = 0; i < size; i++) {
                if (i < maxNum && i > minNum) {
                    cutList.add(list.get(i));
                }
                if (i > maxNum)
                    break;
            }
        }
        list = cutList;
        num = cutList.size();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
