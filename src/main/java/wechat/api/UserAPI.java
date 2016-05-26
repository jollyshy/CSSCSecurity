package wechat.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import wechat.bean.user.User;
import wechat.client.LocalHttpClient;
import wechat.util.EmojiUtil;

/**
 * Created by wenqing on 2016/5/23.
 */
public class UserAPI extends BaseAPI {

    /**
     * ��ȡ�û�������Ϣ
     * @param access_token
     * @param openid
     * @return
     */
    public static User userInfo(String access_token,String openid){
        return userInfo(access_token, openid, 0);
    }

    /**
     * ��ȡ�û�������Ϣ
     * @since 2.7.1
     * @param access_token
     * @param openid
     * @param emoji ���������ʽ<br>
     * 0 		  ������ <br>
     * 1 HtmlHex ��ʽ<br>
     * 2 HtmlTag ��ʽ<br>
     * 3 Alias  ��ʽ<br>
     * 4 HtmlDec ��ʽ<br>
     * 5 PureText ���ı�<br>
     * @return
     */
    public static User userInfo(String access_token,String openid,int emoji){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI+"/cgi-bin/user/info")
                .addParameter(PARAM_ACCESS_TOKEN,access_token)
                .addParameter("openid",openid)
                .addParameter("lang","zh_CN")
                .build();
        User user = LocalHttpClient.executeJsonResult(httpUriRequest, User.class);
        if(emoji != 0 && user != null && user.getNickname() != null){
            user.setNickname_emoji(EmojiUtil.parse(user.getNickname(), emoji));
        }
        return user;
    }


}
