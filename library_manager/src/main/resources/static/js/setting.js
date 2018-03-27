$(function () {
    var info = getCookie("info");
    if (info == 0) {
        $('title').text("图书管理系统-学生端");
        $('.brand').text("图书管理系统-学生端");

    } else if(info == 1) {
        $('title').text("图书管理系统-教师端");
        $('.brand').text("图书管理系统-教师端");
    }
    $('#username').text(getCookie("username"));
    $('#exit').on('click', function () {
        setCookie("info", 1, -1)
        setCookie("username", 1, -1)
        location.href = "/page/login";
    })

});
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); //正则匹配
    if(arr = document.cookie.match(reg)){
        return unescape(arr[2]);
    }
    else {
        return null;
    }
}
function setCookie(name, value, iDay){


    var oDate=new Date();

    oDate.setDate(oDate.getDate()+iDay);

    document.cookie=name+'='+value+';expires='+oDate;

}