package com.jelly.simplemvp.main.bean;

import java.util.List;

public class NewsList {

    /**
     * IsSuccess : true
     * ErrorMessage :
     * Data : {"TreeList":[],"NewList":[{"ID":1539569118656980,"NewID":656980,"NewTitle":"第一上海：予安踏体育\u201c买入\u201d 评级","Intro":"  三季度业绩亮眼,品牌零售金额继续保持高增速  三季度","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/10/15 10:05:18","CreateTime":"2018/10/15 10:06:44"},{"ID":1538967516648106,"NewID":648106,"NewTitle":"信达国际：通达集团短线目标价1.3元 18.1%潜在升幅","Intro":"  因素：  i) 集团2018年上半年业绩大致符合市场预期，期","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/10/08 10:58:36","CreateTime":"2018/10/08 11:03:35"},{"ID":1538019056638540,"NewID":638540,"NewTitle":"东方财富证券：首次予浪潮国际买入评级 目标价5.55港元","Intro":"  【投资要点】  公司聚焦于企业信息化建设。公司是国内管","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/27 11:30:56","CreateTime":"2018/09/27 11:31:54"},{"ID":1537514677633125,"NewID":633125,"NewTitle":"国元国际：予浪潮国际\u201c推荐\u201d评级 目标价3.7元","Intro":"  传统管理软件增长超预期 未来重点开拓大型企业市场： ","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/21 15:24:37","CreateTime":"2018/09/21 15:25:18"},{"ID":1537344309629944,"NewID":629944,"NewTitle":"方正香港：优源控股中期收入增长强劲 业务维持稳定增长","Intro":"  收入增长强劲：优源控股（2268.HK）2018年上半年收入按年","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/19 16:05:09","CreateTime":"2018/09/19 16:05:51"},{"ID":1537236849628146,"NewID":628146,"NewTitle":"项目将试业 海昌海洋公园看高一线 建议买入价1.68元","Intro":"  内地多个省市致力促进旅游业发展，海昌海洋公园（02255","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 10:14:09","CreateTime":"2018/09/18 10:15:58"},{"ID":1537236726628140,"NewID":628140,"NewTitle":"第一上海：予福寿园\u201c买入\u201d 评级","Intro":"  中期业绩稳健增长，业务调整符合政策方针  中期业绩稳","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 10:12:06","CreateTime":"2018/09/18 10:12:57"},{"ID":1537235707628111,"NewID":628111,"NewTitle":"信达国际：中国重汽短线目标价16.0元 14.3%潜在升幅","Intro":"  因素：  i) 集团2018年上半年业绩理想，期内收入及纯利","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 09:55:07","CreateTime":"2018/09/18 09:55:56"},{"ID":1536891353624757,"NewID":624757,"NewTitle":"信达国际：安踏体育短线目标价38.1元 12.0%潜在升幅","Intro":"  因素：  i) 受惠FILA贡献增加及安踏主品牌平均单价上升","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/14 10:15:53","CreateTime":"2018/09/14 10:16:47"},{"ID":1536724226621524,"NewID":621524,"NewTitle":"第一上海：予民生教育\u201c买入\u201d 评级","Intro":"  外延并购稳步进行，获得大额低息融资支持  净利润同比","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/12 11:50:26","CreateTime":"2018/09/12 11:51:20"}],"Cache":0}
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
         * TreeList : []
         * NewList : [{"ID":1539569118656980,"NewID":656980,"NewTitle":"第一上海：予安踏体育\u201c买入\u201d 评级","Intro":"  三季度业绩亮眼,品牌零售金额继续保持高增速  三季度","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/10/15 10:05:18","CreateTime":"2018/10/15 10:06:44"},{"ID":1538967516648106,"NewID":648106,"NewTitle":"信达国际：通达集团短线目标价1.3元 18.1%潜在升幅","Intro":"  因素：  i) 集团2018年上半年业绩大致符合市场预期，期","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/10/08 10:58:36","CreateTime":"2018/10/08 11:03:35"},{"ID":1538019056638540,"NewID":638540,"NewTitle":"东方财富证券：首次予浪潮国际买入评级 目标价5.55港元","Intro":"  【投资要点】  公司聚焦于企业信息化建设。公司是国内管","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/27 11:30:56","CreateTime":"2018/09/27 11:31:54"},{"ID":1537514677633125,"NewID":633125,"NewTitle":"国元国际：予浪潮国际\u201c推荐\u201d评级 目标价3.7元","Intro":"  传统管理软件增长超预期 未来重点开拓大型企业市场： ","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/21 15:24:37","CreateTime":"2018/09/21 15:25:18"},{"ID":1537344309629944,"NewID":629944,"NewTitle":"方正香港：优源控股中期收入增长强劲 业务维持稳定增长","Intro":"  收入增长强劲：优源控股（2268.HK）2018年上半年收入按年","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/19 16:05:09","CreateTime":"2018/09/19 16:05:51"},{"ID":1537236849628146,"NewID":628146,"NewTitle":"项目将试业 海昌海洋公园看高一线 建议买入价1.68元","Intro":"  内地多个省市致力促进旅游业发展，海昌海洋公园（02255","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 10:14:09","CreateTime":"2018/09/18 10:15:58"},{"ID":1537236726628140,"NewID":628140,"NewTitle":"第一上海：予福寿园\u201c买入\u201d 评级","Intro":"  中期业绩稳健增长，业务调整符合政策方针  中期业绩稳","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 10:12:06","CreateTime":"2018/09/18 10:12:57"},{"ID":1537235707628111,"NewID":628111,"NewTitle":"信达国际：中国重汽短线目标价16.0元 14.3%潜在升幅","Intro":"  因素：  i) 集团2018年上半年业绩理想，期内收入及纯利","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/18 09:55:07","CreateTime":"2018/09/18 09:55:56"},{"ID":1536891353624757,"NewID":624757,"NewTitle":"信达国际：安踏体育短线目标价38.1元 12.0%潜在升幅","Intro":"  因素：  i) 受惠FILA贡献增加及安踏主品牌平均单价上升","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/14 10:15:53","CreateTime":"2018/09/14 10:16:47"},{"ID":1536724226621524,"NewID":621524,"NewTitle":"第一上海：予民生教育\u201c买入\u201d 评级","Intro":"  外延并购稳步进行，获得大额低息融资支持  净利润同比","Market":"2","Code":"","ImageUrl":"","Logo":"","SourceName":"腾讯证券","StockName":"","PublishTime":"2018/09/12 11:50:26","CreateTime":"2018/09/12 11:51:20"}]
         * Cache : 0
         */

        private int Cache;
        private List<?> TreeList;
        private List<NewListBean> NewList;

        public int getCache() {
            return Cache;
        }

        public void setCache(int Cache) {
            this.Cache = Cache;
        }

        public List<?> getTreeList() {
            return TreeList;
        }

        public void setTreeList(List<?> TreeList) {
            this.TreeList = TreeList;
        }

        public List<NewListBean> getNewList() {
            return NewList;
        }

        public void setNewList(List<NewListBean> NewList) {
            this.NewList = NewList;
        }

        public static class NewListBean {
            /**
             * ID : 1539569118656980
             * NewID : 656980
             * NewTitle : 第一上海：予安踏体育“买入” 评级
             * Intro :   三季度业绩亮眼,品牌零售金额继续保持高增速  三季度
             * Market : 2
             * Code :
             * ImageUrl :
             * Logo :
             * SourceName : 腾讯证券
             * StockName :
             * PublishTime : 2018/10/15 10:05:18
             * CreateTime : 2018/10/15 10:06:44
             */

            private long ID;
            private int NewID;
            private String NewTitle;
            private String Intro;
            private String Market;
            private String Code;
            private String ImageUrl;
            private String Logo;
            private String SourceName;
            private String StockName;
            private String PublishTime;
            private String CreateTime;

            public long getID() {
                return ID;
            }

            public void setID(long ID) {
                this.ID = ID;
            }

            public int getNewID() {
                return NewID;
            }

            public void setNewID(int NewID) {
                this.NewID = NewID;
            }

            public String getNewTitle() {
                return NewTitle;
            }

            public void setNewTitle(String NewTitle) {
                this.NewTitle = NewTitle;
            }

            public String getIntro() {
                return Intro;
            }

            public void setIntro(String Intro) {
                this.Intro = Intro;
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

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getLogo() {
                return Logo;
            }

            public void setLogo(String Logo) {
                this.Logo = Logo;
            }

            public String getSourceName() {
                return SourceName;
            }

            public void setSourceName(String SourceName) {
                this.SourceName = SourceName;
            }

            public String getStockName() {
                return StockName;
            }

            public void setStockName(String StockName) {
                this.StockName = StockName;
            }

            public String getPublishTime() {
                return PublishTime;
            }

            public void setPublishTime(String PublishTime) {
                this.PublishTime = PublishTime;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }
        }
    }
}
