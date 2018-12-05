package com.baise.school.data.entity;

import java.util.List;

/**
 * @author 小强
 * @time 2018/7/13  15:18
 * @desc 登录实体类
 */
public class LoginEntity {


    /**
     * username : 18822223335
     * name : 小强无限公司
     * password_md5 : 25d55ad283aa400af464c76d713c07ad
     * phone : 18822223335
     * user_type : 2
     * last_login_datetime : 2018-07-16 17:31:38
     * login_count : 4752
     * locked : false
     * token :
     * 8A14C274380A3A4F7BB8B6C297CEB492EC515F3DFE8CCCC1EFCD8E0B4F27ACD05AB2EDAC6C23E485EFFDE3C44D07ECFB1A77F75A3D8492E932F8533A311DB12E8C38FD663FA2884AFB7D5B1B41763621D7977E91EF8BD57B03E3AB977DC4E010D8B3AD6B2664DD5180338D702776811D9F8D4A60E3D37F10B90F1F2AC0A528D
     * is_judges : false
     * user_info : {"id":15,"user_id":17,"head_img":"http://192.168.7.100:8028/files/img/20180711/201807111409547429.png","nickname":"小强无限公司","age":99,"sex":1,"province":"","city":"",
     * "ibean_count":29938,"total_reward_price":176.49,"price":7.57,"create_datetime":"2018-01-02 18:07:36","update_datetime":"2018-07-11 15:09:56"}
     * role : [{"id":122,"roleId":3,"actionType":"Images","actionValue":""},{"id":123,"roleId":3,"actionType":"Font","actionValue":""},{"id":124,"roleId":3,"actionType":"Animation",
     * "actionValue":"0"},{"id":125,"roleId":3,"actionType":"FreeTemplate","actionValue":""},{"id":126,"roleId":3,"actionType":"ChargeTemplateForFree","actionValue":"5"},{"id":127,"roleId":3,
     * "actionType":"ChargeTemplate","actionValue":"0.3"},{"id":128,"roleId":3,"actionType":"Psd","actionValue":""},{"id":129,"roleId":3,"actionType":"ToolBase","actionValue":""},{"id":130,
     * "roleId":3,"actionType":"ToolAdvanced","actionValue":""},{"id":131,"roleId":3,"actionType":"ProductAnalysis","actionValue":""},{"id":132,"roleId":3,"actionType":"ArticleAnalysis",
     * "actionValue":""},{"id":133,"roleId":3,"actionType":"FansAnalysis","actionValue":""},{"id":134,"roleId":3,"actionType":"OrderAnalysis","actionValue":""},{"id":135,"roleId":3,
     * "actionType":"DataAnalysis","actionValue":""},{"id":136,"roleId":3,"actionType":"Forward","actionValue":""},{"id":137,"roleId":3,"actionType":"TitleOptimization","actionValue":""},{"id":138,
     * "roleId":3,"actionType":"OnlineService","actionValue":""},{"id":139,"roleId":3,"actionType":"Remind","actionValue":""},{"id":140,"roleId":3,"actionType":"DemandService","actionValue":""},
     * {"id":141,"roleId":3,"actionType":"Demand","actionValue":"0.6"},{"id":142,"roleId":3,"actionType":"InfoService","actionValue":""},{"id":143,"roleId":3,"actionType":"Info","actionValue":""},
     * {"id":144,"roleId":3,"actionType":"InfoNumber","actionValue":""}]
     * user_operation : {"message_count":0,"comment_count":154,"follow_count":10}
     * other_info : {"id":9,"user_id":17,"check_status":2,"name":"小强无限公司","short_name":"上杰集团","scale":"","trade":"133,140","city":"340400","province":"340000","version":3,
     * "start_datetime":"2018-01-13 11:45:33","end_datetime":"2018-01-13 11:45:33","certificates_type":2,"certificates_url":"http://192.168.7.100:8028/files/img/20180113/201801131142129982.png",
     * "create_datetime":"2018-01-13 11:45:33","update_datetime":"2018-07-11 15:09:56","message":"","reply_datetime":"1900-01-01 00:00:00","profession_id":0,"profession_name":"CEO"}
     * channelList : null
     */

    private String username;
    private String name;
    private String password_md5;
    private String phone;
    private int user_type;
    private String last_login_datetime;
    private int login_count;
    private boolean locked;
    private String token;
    private boolean is_judges;
    /**
     * id : 15
     * user_id : 17
     * head_img : http://192.168.7.100:8028/files/img/20180711/201807111409547429.png
     * nickname : 小强无限公司
     * age : 99
     * sex : 1
     * province :
     * city :
     * ibean_count : 29938
     * total_reward_price : 176.49
     * price : 7.57
     * create_datetime : 2018-01-02 18:07:36
     * update_datetime : 2018-07-11 15:09:56
     */

    private UserInfoBean user_info;
    /**
     * message_count : 0
     * comment_count : 154
     * follow_count : 10
     */

    private UserOperationBean user_operation;
    /**
     * id : 9
     * user_id : 17
     * check_status : 2
     * name : 小强无限公司
     * short_name : 上杰集团
     * scale :
     * trade : 133,140
     * city : 340400
     * province : 340000
     * version : 3
     * start_datetime : 2018-01-13 11:45:33
     * end_datetime : 2018-01-13 11:45:33
     * certificates_type : 2
     * certificates_url : http://192.168.7.100:8028/files/img/20180113/201801131142129982.png
     * create_datetime : 2018-01-13 11:45:33
     * update_datetime : 2018-07-11 15:09:56
     * message :
     * reply_datetime : 1900-01-01 00:00:00
     * profession_id : 0
     * profession_name : CEO
     */

    private OtherInfoBean other_info;
    private Object channelList;
    /**
     * id : 122
     * roleId : 3
     * actionType : Images
     * actionValue :
     */

    private List<RoleBean> role;

    public String getUsername() { return username;}

    public void setUsername(String username) { this.username = username;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getPassword_md5() { return password_md5;}

    public void setPassword_md5(String password_md5) { this.password_md5 = password_md5;}

    public String getPhone() { return phone;}

    public void setPhone(String phone) { this.phone = phone;}

    public int getUser_type() { return user_type;}

    public void setUser_type(int user_type) { this.user_type = user_type;}

    public String getLast_login_datetime() { return last_login_datetime;}

    public void setLast_login_datetime(String last_login_datetime) { this.last_login_datetime = last_login_datetime;}

    public int getLogin_count() { return login_count;}

    public void setLogin_count(int login_count) { this.login_count = login_count;}

    public boolean isLocked() { return locked;}

    public void setLocked(boolean locked) { this.locked = locked;}

    public String getToken() { return token;}

    public void setToken(String token) { this.token = token;}

    public boolean isIs_judges() { return is_judges;}

    public void setIs_judges(boolean is_judges) { this.is_judges = is_judges;}

    public UserInfoBean getUser_info() { return user_info;}

    public void setUser_info(UserInfoBean user_info) { this.user_info = user_info;}

    public UserOperationBean getUser_operation() { return user_operation;}

    public void setUser_operation(UserOperationBean user_operation) { this.user_operation = user_operation;}

    public OtherInfoBean getOther_info() { return other_info;}

    public void setOther_info(OtherInfoBean other_info) { this.other_info = other_info;}

    public Object getChannelList() { return channelList;}

    public void setChannelList(Object channelList) { this.channelList = channelList;}

    public List<RoleBean> getRole() { return role;}

    public void setRole(List<RoleBean> role) { this.role = role;}

    public static class UserInfoBean {
        private int id;
        private int user_id;
        private String head_img;
        private String nickname;
        private int age;
        private int sex;
        private String province;
        private String city;
        private int ibean_count;
        private double total_reward_price;
        private double price;
        private String create_datetime;
        private String update_datetime;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public int getUser_id() { return user_id;}

        public void setUser_id(int user_id) { this.user_id = user_id;}

        public String getHead_img() { return head_img;}

        public void setHead_img(String head_img) { this.head_img = head_img;}

        public String getNickname() { return nickname;}

        public void setNickname(String nickname) { this.nickname = nickname;}

        public int getAge() { return age;}

        public void setAge(int age) { this.age = age;}

        public int getSex() { return sex;}

        public void setSex(int sex) { this.sex = sex;}

        public String getProvince() { return province;}

        public void setProvince(String province) { this.province = province;}

        public String getCity() { return city;}

        public void setCity(String city) { this.city = city;}

        public int getIbean_count() { return ibean_count;}

        public void setIbean_count(int ibean_count) { this.ibean_count = ibean_count;}

        public double getTotal_reward_price() { return total_reward_price;}

        public void setTotal_reward_price(double total_reward_price) { this.total_reward_price = total_reward_price;}

        public double getPrice() { return price;}

        public void setPrice(double price) { this.price = price;}

        public String getCreate_datetime() { return create_datetime;}

        public void setCreate_datetime(String create_datetime) { this.create_datetime = create_datetime;}

        public String getUpdate_datetime() { return update_datetime;}

        public void setUpdate_datetime(String update_datetime) { this.update_datetime = update_datetime;}

        @Override
        public String toString() {
            return "UserInfoBean{" + "id=" + id + ", user_id=" + user_id + ", head_img='" + head_img + '\'' + ", nickname='" + nickname + '\'' + ", age=" + age + ", sex=" + sex + ", province='" +
                    province + '\'' + ", city='" + city + '\'' + ", ibean_count=" + ibean_count + ", total_reward_price=" + total_reward_price + ", price=" + price + ", create_datetime='" +
                    create_datetime + '\'' + ", update_datetime='" + update_datetime + '\'' + '}';
        }
    }

    public static class UserOperationBean {
        private int message_count;
        private int comment_count;
        private int follow_count;

        public int getMessage_count() { return message_count;}

        public void setMessage_count(int message_count) { this.message_count = message_count;}

        public int getComment_count() { return comment_count;}

        public void setComment_count(int comment_count) { this.comment_count = comment_count;}

        public int getFollow_count() { return follow_count;}

        public void setFollow_count(int follow_count) { this.follow_count = follow_count;}

        @Override
        public String toString() {
            return "UserOperationBean{" + "message_count=" + message_count + ", comment_count=" + comment_count + ", follow_count=" + follow_count + '}';
        }
    }

    public static class OtherInfoBean {
        private int id;
        private int user_id;
        private int check_status;
        private String name;
        private String short_name;
        private String scale;
        private String trade;
        private String city;
        private String province;
        private int version;
        private String start_datetime;
        private String end_datetime;
        private int certificates_type;
        private String certificates_url;
        private String create_datetime;
        private String update_datetime;
        private String message;
        private String reply_datetime;
        private int profession_id;
        private String profession_name;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public int getUser_id() { return user_id;}

        public void setUser_id(int user_id) { this.user_id = user_id;}

        public int getCheck_status() { return check_status;}

        public void setCheck_status(int check_status) { this.check_status = check_status;}

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public String getShort_name() { return short_name;}

        public void setShort_name(String short_name) { this.short_name = short_name;}

        public String getScale() { return scale;}

        public void setScale(String scale) { this.scale = scale;}

        public String getTrade() { return trade;}

        public void setTrade(String trade) { this.trade = trade;}

        public String getCity() { return city;}

        public void setCity(String city) { this.city = city;}

        public String getProvince() { return province;}

        public void setProvince(String province) { this.province = province;}

        public int getVersion() { return version;}

        public void setVersion(int version) { this.version = version;}

        public String getStart_datetime() { return start_datetime;}

        public void setStart_datetime(String start_datetime) { this.start_datetime = start_datetime;}

        public String getEnd_datetime() { return end_datetime;}

        public void setEnd_datetime(String end_datetime) { this.end_datetime = end_datetime;}

        public int getCertificates_type() { return certificates_type;}

        public void setCertificates_type(int certificates_type) { this.certificates_type = certificates_type;}

        public String getCertificates_url() { return certificates_url;}

        public void setCertificates_url(String certificates_url) { this.certificates_url = certificates_url;}

        public String getCreate_datetime() { return create_datetime;}

        public void setCreate_datetime(String create_datetime) { this.create_datetime = create_datetime;}

        public String getUpdate_datetime() { return update_datetime;}

        public void setUpdate_datetime(String update_datetime) { this.update_datetime = update_datetime;}

        public String getMessage() { return message;}

        public void setMessage(String message) { this.message = message;}

        public String getReply_datetime() { return reply_datetime;}

        public void setReply_datetime(String reply_datetime) { this.reply_datetime = reply_datetime;}

        public int getProfession_id() { return profession_id;}

        public void setProfession_id(int profession_id) { this.profession_id = profession_id;}

        public String getProfession_name() { return profession_name;}

        public void setProfession_name(String profession_name) { this.profession_name = profession_name;}

        @Override
        public String toString() {
            return "OtherInfoBean{" + "id=" + id + ", user_id=" + user_id + ", check_status=" + check_status + ", name='" + name + '\'' + ", short_name='" + short_name + '\'' + ", scale='" + scale
                    + '\'' + ", trade='" + trade + '\'' + ", city='" + city + '\'' + ", province='" + province + '\'' + ", version=" + version + ", start_datetime='" + start_datetime + '\'' + ", " +
                    "end_datetime='" + end_datetime + '\'' + ", certificates_type=" + certificates_type + ", certificates_url='" + certificates_url + '\'' + ", create_datetime='" + create_datetime
                    + '\'' + ", update_datetime='" + update_datetime + '\'' + ", message='" + message + '\'' + ", reply_datetime='" + reply_datetime + '\'' + ", profession_id=" + profession_id + "," +
                    " profession_name='" + profession_name + '\'' + '}';
        }
    }

    public static class RoleBean {
        private int id;
        private int roleId;
        private String actionType;
        private String actionValue;

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public int getRoleId() { return roleId;}

        public void setRoleId(int roleId) { this.roleId = roleId;}

        public String getActionType() { return actionType;}

        public void setActionType(String actionType) { this.actionType = actionType;}

        public String getActionValue() { return actionValue;}

        public void setActionValue(String actionValue) { this.actionValue = actionValue;}

        @Override
        public String toString() {
            return "RoleBean{" + "id=" + id + ", roleId=" + roleId + ", actionType='" + actionType + '\'' + ", actionValue='" + actionValue + '\'' + '}';
        }
    }

    @Override
    public String toString() {
        return "LoginEntity{" + "username='" + username + '\'' + ", name='" + name + '\'' + ", password_md5='" + password_md5 + '\'' + ", phone='" + phone + '\'' + ", user_type=" + user_type + ", " +
                "last_login_datetime='" + last_login_datetime + '\'' + ", login_count=" + login_count + ", locked=" + locked + ", token='" + token + '\'' + ", is_judges=" + is_judges + ", " +
                "user_info=" + user_info + ", user_operation=" + user_operation + ", other_info=" + other_info + ", channelList=" + channelList + ", role=" + role + '}';
    }
}
