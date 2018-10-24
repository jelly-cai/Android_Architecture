package com.jelly.architecture.content.bean;

import java.util.List;

public class NewContent {

    /**
     * IsSuccess : true
     * ErrorMessage :
     * Data : {"Cache":1,"NewID":603797,"Market":"2","Code":"00852","SourceName":"披露易","ImageUrl":"","NewTitle":"&nbsp;&nbsp;海峽石油化工(00852) &nbsp;&nbsp;財務報表/環境、社會及管治資料 - [中期/半年度報告]","NewContent":"<a href=\"http://218.17.205.6:8083/DownPdf/listedco/listconews/sehk/2018/0830/LTN20180830394_C.pdf\" target=\"_new\">  中期報告 2018 (4883KB, PDF)<\/a>","CreateTime":"2018/08/30 16:43:20","PublishTime":"2018/08/30 16:43:00","ViewCount":3,"ListStock":[]}
     */

    private boolean IsSuccess;
    private String ErrorMessage;
    private DataBean Data;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Cache : 1
         * NewID : 603797
         * Market : 2
         * Code : 00852
         * SourceName : 披露易
         * ImageUrl :
         * NewTitle : &nbsp;&nbsp;海峽石油化工(00852) &nbsp;&nbsp;財務報表/環境、社會及管治資料 - [中期/半年度報告]
         * NewContent : <a href="http://218.17.205.6:8083/DownPdf/listedco/listconews/sehk/2018/0830/LTN20180830394_C.pdf" target="_new">  中期報告 2018 (4883KB, PDF)</a>
         * CreateTime : 2018/08/30 16:43:20
         * PublishTime : 2018/08/30 16:43:00
         * ViewCount : 3
         * ListStock : []
         */

        private int Cache;
        private int NewID;
        private String Market;
        private String Code;
        private String SourceName;
        private String ImageUrl;
        private String NewTitle;
        private String NewContent;
        private String CreateTime;
        private String PublishTime;
        private int ViewCount;
        private List<?> ListStock;

        public int getCache() {
            return Cache;
        }

        public void setCache(int Cache) {
            this.Cache = Cache;
        }

        public int getNewID() {
            return NewID;
        }

        public void setNewID(int NewID) {
            this.NewID = NewID;
        }

        public String getMarket() {
            return Market;
        }

        public void setMarket(String Market) {
            this.Market = Market;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public String getSourceName() {
            return SourceName;
        }

        public void setSourceName(String SourceName) {
            this.SourceName = SourceName;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public String getNewTitle() {
            return NewTitle;
        }

        public void setNewTitle(String NewTitle) {
            this.NewTitle = NewTitle;
        }

        public String getNewContent() {
            return NewContent;
        }

        public void setNewContent(String NewContent) {
            this.NewContent = NewContent;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getPublishTime() {
            return PublishTime;
        }

        public void setPublishTime(String PublishTime) {
            this.PublishTime = PublishTime;
        }

        public int getViewCount() {
            return ViewCount;
        }

        public void setViewCount(int ViewCount) {
            this.ViewCount = ViewCount;
        }

        public List<?> getListStock() {
            return ListStock;
        }

        public void setListStock(List<?> ListStock) {
            this.ListStock = ListStock;
        }
    }
}
