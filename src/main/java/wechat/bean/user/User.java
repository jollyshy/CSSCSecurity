package wechat.bean.user;

import wechat.bean.BaseResult;

import java.util.Arrays;

/**
 * Created by wenqing on 2016/5/23.
 */
public class User extends BaseResult {

    @Override
    public String toString() {
        return "User{" +
                "subscribe=" + subscribe +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nickname_emoji='" + nickname_emoji + '\'' +
                ", sex=" + sex +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribe_time=" + subscribe_time +
                ", privilege=" + Arrays.toString(privilege) +
                ", unionid='" + unionid + '\'' +
                ", groupid=" + groupid +
                ", remark='" + remark + '\'' +
                ", tagid_list=" + Arrays.toString(tagid_list) +
                '}';
    }

    private Integer subscribe;		//�û��Ƿ��ĸù��ںű�ʶ��ֵΪ0ʱ��������û�û�й�ע�ù��ںţ���ȡ����������Ϣ��

    private String openid;			//�û��ı�ʶ���Ե�ǰ���ں�Ψһ

    private String nickname;

    private String nickname_emoji;	//�ǳ� ����ת��

    private Integer sex;			//�û����Ա�ֵΪ1ʱ�����ԣ�ֵΪ2ʱ��Ů�ԣ�ֵΪ0ʱ��δ֪

    private String language;

    private String city;

    private String province;

    private String country;

    private String headimgurl;

    private Integer subscribe_time;

    private String[] privilege;		//sns �û���Ȩ��Ϣ��json ���飬��΢���ֿ��û�Ϊ��chinaunicom��

    private String unionid;			//������ں�֮���û��ʺŻ�ͨUnionID����

    private Integer groupid;

    private String remark;			//���ں���Ӫ�߶Է�˿�ı�ע�����ں���Ӫ�߿���΢�Ź���ƽ̨�û��������Է�˿��ӱ�ע

    private Integer[] tagid_list;	//�û������ϵı�ǩID�б�

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Integer subscribeTime) {
        subscribe_time = subscribeTime;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getGroupid(){
        return groupid;
    }

    public void setGroupid(Integer groupid){
        this.groupid = groupid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(Integer[] tagid_list) {
        this.tagid_list = tagid_list;
    }

    public String getNickname_emoji() {
        return nickname_emoji;
    }

    public void setNickname_emoji(String nickname_emoji) {
        this.nickname_emoji = nickname_emoji;
    }
}

