/**
 * Created by huchao on 2016/7/6.
 */
//��֤����
jQuery.validator.addMethod( "checkEmail",function(value,element){
    var myreg = /^[_a-zA-Z0-9\-]+(\.[_a-zA-Z0-9\-]*)*@[a-zA-Z0-9\-]+([\.][a-zA-Z0-9\-]+)+$/;
    if(value !=''){if(!myreg.test(value)){return false;}};
    return true;
} , " ��������Ч��E_mail");
//��֤���� 6-18λ���ַ����ֺ����������� �ų��ո�..
jQuery.validator.addMethod("checkPassword",function(value, element) {
    var myreg = /^[^\s]{6,18}$/;
    if (value != '') {if (!myreg.test(value)) {return false;}};
    return true;}, "��������Ч����!");
// ��ϵ�绰(�ֻ�/�绰�Կ�)��֤
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    console.log(value);
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "����ȷ��д�����ֻ�����");