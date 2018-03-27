$(function () {
    var info = getCookie("info");
    console.log(info)
    if (info == 0) {
        $('title').text("图书管理系统-学生端");
        $('.brand').text("图书管理系统-学生端");

    } else if(info == 1) {
        $('title').text("图书管理系统-教师端");
        $('.brand').text("图书管理系统-教师端");
    }
    $('#username').text(getCookie("username"));

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