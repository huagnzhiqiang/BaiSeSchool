package com.baise.school.data.entity;

import java.util.List;

/**
 * @author 小强
 * @time 2018/7/13  14:58
 * @desc
 */
public class MineEntity {


    /**
     * code : 200
     * data : {"total":19,"rows":[{"id":"296","order_no":"18052114503424","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=296","price":0.2,"order_status":1,"create_datetime":"2018-05-21 14:50:34"},{"id":"295","order_no":"18052114433859","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=295","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:43:38"},{"id":"294","order_no":"18052114410330","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=294","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:41:03"},{"id":"293","order_no":"18052114385635","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=293","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:38:56"},{"id":"291","order_no":"18052114084687","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=291","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:08:46"},{"id":"290","order_no":"18052110224769","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=290","price":0.2,"order_status":0,"create_datetime":"2018-05-21 10:22:47"},{"id":"288","order_no":"18051921021183","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223391","name":"002","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=288","price":0.1,"order_status":0,"create_datetime":"2018-05-19 21:02:11"},{"id":"285","order_no":"18051918364612","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=285","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:36:46"},{"id":"284","order_no":"18051918235716","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=284","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:23:57"},{"id":"283","order_no":"18051918045306","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=283","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:04:53"},{"id":"282","order_no":"18051918031927","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=282","price":0.2,"order_status":0,"create_datetime":"2018-05-19 18:03:19"},{"id":"281","order_no":"18051917235155","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223341","name":"测试一号","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=281","price":0.3,"order_status":2,"create_datetime":"2018-05-19 17:23:51"},{"id":"280","order_no":"18051917224688","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223341","name":"测试一号","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=280","price":0.2,"order_status":0,"create_datetime":"2018-05-19 17:22:46"},{"id":"278","order_no":"18051714285205","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=278","price":0.1,"order_status":1,"create_datetime":"2018-05-17 14:28:52"},{"id":"277","order_no":"18051714274479","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"ghj","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=277","price":0.2,"order_status":1,"create_datetime":"2018-05-17 14:27:44"},{"id":"276","order_no":"18051714273653","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"ghj","share_count":"2","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=276","price":2,"order_status":3,"create_datetime":"2018-05-17 14:27:36"},{"id":"275","order_no":"18051216485330","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"13222222222","name":"普通用户12","product_name":"我们不一样","share_count":"1","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=275","price":1,"order_status":1,"create_datetime":"2018-05-12 16:48:53"},{"id":"273","order_no":"18051115010745","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223388","name":"Name","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=273","price":0.2,"order_status":0,"create_datetime":"2018-05-11 15:01:07"},{"id":"272","order_no":"18051114580972","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223391","name":"002","product_name":"ghj","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=272","price":0.5,"order_status":0,"create_datetime":"2018-05-11 14:58:09"}]}
     * message : 查询成功
     * remark :
     */

    private String code;
    /**
     * total : 19
     * rows : [{"id":"296","order_no":"18052114503424","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=296","price":0.2,"order_status":1,"create_datetime":"2018-05-21 14:50:34"},{"id":"295","order_no":"18052114433859","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=295","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:43:38"},{"id":"294","order_no":"18052114410330","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=294","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:41:03"},{"id":"293","order_no":"18052114385635","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=293","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:38:56"},{"id":"291","order_no":"18052114084687","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=291","price":0.1,"order_status":0,"create_datetime":"2018-05-21 14:08:46"},{"id":"290","order_no":"18052110224769","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=290","price":0.2,"order_status":0,"create_datetime":"2018-05-21 10:22:47"},{"id":"288","order_no":"18051921021183","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223391","name":"002","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=288","price":0.1,"order_status":0,"create_datetime":"2018-05-19 21:02:11"},{"id":"285","order_no":"18051918364612","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=285","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:36:46"},{"id":"284","order_no":"18051918235716","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=284","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:23:57"},{"id":"283","order_no":"18051918045306","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=283","price":0.1,"order_status":0,"create_datetime":"2018-05-19 18:04:53"},{"id":"282","order_no":"18051918031927","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18900000001","name":"小猪佩奇","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=282","price":0.2,"order_status":0,"create_datetime":"2018-05-19 18:03:19"},{"id":"281","order_no":"18051917235155","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223341","name":"测试一号","product_name":"哦哦哦","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=281","price":0.3,"order_status":2,"create_datetime":"2018-05-19 17:23:51"},{"id":"280","order_no":"18051917224688","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223341","name":"测试一号","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=280","price":0.2,"order_status":0,"create_datetime":"2018-05-19 17:22:46"},{"id":"278","order_no":"18051714285205","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=278","price":0.1,"order_status":1,"create_datetime":"2018-05-17 14:28:52"},{"id":"277","order_no":"18051714274479","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"ghj","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=277","price":0.2,"order_status":1,"create_datetime":"2018-05-17 14:27:44"},{"id":"276","order_no":"18051714273653","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223343","name":"机灵小不懂","product_name":"ghj","share_count":"2","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=276","price":2,"order_status":3,"create_datetime":"2018-05-17 14:27:36"},{"id":"275","order_no":"18051216485330","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"13222222222","name":"普通用户12","product_name":"我们不一样","share_count":"1","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=275","price":1,"order_status":1,"create_datetime":"2018-05-12 16:48:53"},{"id":"273","order_no":"18051115010745","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223388","name":"Name","product_name":"我们不一样","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=273","price":0.2,"order_status":0,"create_datetime":"2018-05-11 15:01:07"},{"id":"272","order_no":"18051114580972","article_type":1,"customer_phone":"18822223335","customer_name":"小强无限公司","phone":"18822223391","name":"002","product_name":"ghj","share_count":"0","browse_count":"0","product_url":"http://m.creatby.com/v2/manage/book/ydcnxx/?appId=272","price":0.5,"order_status":0,"create_datetime":"2018-05-11 14:58:09"}]
     */

    private DataBean data;
    private String message;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class DataBean {
        private int total;
        /**
         * id : 296
         * order_no : 18052114503424
         * article_type : 1
         * customer_phone : 18822223335
         * customer_name : 小强无限公司
         * phone : 18822223343
         * name : 机灵小不懂
         * product_name : 我们不一样
         * share_count : 0
         * browse_count : 0
         * product_url : http://m.creatby.com/v2/manage/book/ydcnxx/?appId=296
         * price : 0.2
         * order_status : 1
         * create_datetime : 2018-05-21 14:50:34
         */

        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            private String id;
            private String order_no;
            private int article_type;
            private String customer_phone;
            private String customer_name;
            private String phone;
            private String name;
            private String product_name;
            private String share_count;
            private String browse_count;
            private String product_url;
            private double price;
            private int order_status;
            private String create_datetime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public int getArticle_type() {
                return article_type;
            }

            public void setArticle_type(int article_type) {
                this.article_type = article_type;
            }

            public String getCustomer_phone() {
                return customer_phone;
            }

            public void setCustomer_phone(String customer_phone) {
                this.customer_phone = customer_phone;
            }

            public String getCustomer_name() {
                return customer_name;
            }

            public void setCustomer_name(String customer_name) {
                this.customer_name = customer_name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getShare_count() {
                return share_count;
            }

            public void setShare_count(String share_count) {
                this.share_count = share_count;
            }

            public String getBrowse_count() {
                return browse_count;
            }

            public void setBrowse_count(String browse_count) {
                this.browse_count = browse_count;
            }

            public String getProduct_url() {
                return product_url;
            }

            public void setProduct_url(String product_url) {
                this.product_url = product_url;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getOrder_status() {
                return order_status;
            }

            public void setOrder_status(int order_status) {
                this.order_status = order_status;
            }

            public String getCreate_datetime() {
                return create_datetime;
            }

            public void setCreate_datetime(String create_datetime) {
                this.create_datetime = create_datetime;
            }
        }
    }
}
