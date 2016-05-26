package wechat.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import wechat.bean.SnsToken;
import wechat.bean.user.User;
import wechat.client.LocalHttpClient;
import wechat.util.EmojiUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ��ҳ��Ȩ
 *
 */
public class SnsAPI extends BaseAPI{

    /**
     * ������ҳ��Ȩ URL
     * @param appid
     * @param redirect_uri �Զ�URLEncoder
     * @param snsapi_userinfo
     * @param state ����Ϊ��
     * @return
     */
    public static String connectOauth2Authorize(String appid,String redirect_uri,boolean snsapi_userinfo,String state){
        return connectOauth2Authorize(appid, redirect_uri, snsapi_userinfo, state, null);
    }

    /**
     * ������ҳ��Ȩ URL  (������ƽ̨����)
     * @param appid
     * @param redirect_uri �Զ�URLEncoder
     * @param snsapi_userinfo
     * @param state ����Ϊ��
     * @param component_appid ������ƽ̨����������Ϊ�ա�
     * 			 ���񷽵�appid�������봴�����ںŷ���ɹ��󣬿��ڹ��ںŷ�������ҳ�ҵ�
     * @return
     */
    public static String connectOauth2Authorize(String appid,String redirect_uri,boolean snsapi_userinfo,String state,String component_appid){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(OPEN_URI + "/connect/oauth2/authorize?")
                    .append("appid=").append(appid)
                    .append("&redirect_uri=").append(URLEncoder.encode(redirect_uri, "utf-8"))
                    .append("&response_type=code")
                    .append("&scope=").append(snsapi_userinfo?"snsapi_userinfo":"snsapi_base")
                    .append("&state=").append(state==null?"":state);
            if(component_appid!=null){
                sb.append("&component_appid=").append(component_appid);
            }
            sb.append("#wechat_redirect");
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ͨ��code��ȡ��ҳ��Ȩaccess_token
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    public static SnsToken oauth2AccessToken(String appid,String secret,String code){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/sns/oauth2/access_token")
                .addParameter("appid", appid)
                .addParameter("secret", secret)
                .addParameter("code", code)
                .addParameter("grant_type", "authorization_code")
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, SnsToken.class);
    }

    /**
     * ˢ��access_token
     * @param appid
     * @param refresh_token
     * @return
     */
    public static SnsToken oauth2RefreshToken(String appid,String refresh_token){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/sns/oauth2/refresh_token")
                .addParameter("appid", appid)
                .addParameter("refresh_token", refresh_token)
                .addParameter("grant_type", "refresh_token")
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
    }

    /**
     * ��ȡ�û���Ϣ(��scopeΪ snsapi_userinfo)
     * @param access_token
     * @param openid
     * @param lang ���ҵ������԰汾��zh_CN ���壬zh_TW ���壬en Ӣ��
     * @return
     */
    public static User userinfo(String access_token,String openid,String lang){
        return userinfo(access_token, openid, lang, 0);
    }

    /**
     * ��ȡ�û���Ϣ(��scopeΪ snsapi_userinfo)
     * @since 2.7.1
     * @param access_token
     * @param openid
     * @param lang ���ҵ������԰汾��zh_CN ���壬zh_TW ���壬en Ӣ��
     * @param emoji ���������ʽ<br>
     * 0 		  ������ <br>
     * 1 HtmlHex ��ʽ<br>
     * 2 HtmlTag ��ʽ<br>
     * 3 Alias  ��ʽ<br>
     * 4 HtmlDec ��ʽ<br>
     * 5 PureText ���ı�<br>
     * @return
     */
    public static User userinfo(String access_token,String openid,String lang,int emoji){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/sns/userinfo")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .addParameter("openid", openid)
                .addParameter("lang", lang)
                .build();
        User user = LocalHttpClient.executeJsonResult(httpUriRequest, User.class);
        if(emoji != 0 && user != null && user.getNickname() != null){
            user.setNickname_emoji(EmojiUtil.parse(user.getNickname(), emoji));
        }
        return user;
    }

}
