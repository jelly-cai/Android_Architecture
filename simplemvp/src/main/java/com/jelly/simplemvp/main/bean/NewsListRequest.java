package com.jelly.simplemvp.main.bean;

public class NewsListRequest {


    /**
     * Function : 101
     * PageIndex : 1
     * PageSize : 10
     * LastNewID : 0
     * Desc : 0
     * TreeID : 27786
     * Market : 2004
     * Code : 00763
     * ImgType : 1
     */

    private int Function;
    private int PageIndex;
    private int PageSize;
    private int LastNewID;
    private int Desc;
    private int TreeID;
    private int Market;
    private String Code;
    private int ImgType;

    public int getFunction() {
        return Function;
    }

    public void setFunction(int Function) {
        this.Function = Function;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getLastNewID() {
        return LastNewID;
    }

    public void setLastNewID(int LastNewID) {
        this.LastNewID = LastNewID;
    }

    public int getDesc() {
        return Desc;
    }

    public void setDesc(int Desc) {
        this.Desc = Desc;
    }

    public int getTreeID() {
        return TreeID;
    }

    public void setTreeID(int TreeID) {
        this.TreeID = TreeID;
    }

    public int getMarket() {
        return Market;
    }

    public void setMarket(int Market) {
        this.Market = Market;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public int getImgType() {
        return ImgType;
    }

    public void setImgType(int ImgType) {
        this.ImgType = ImgType;
    }
}
