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


    $('#closeModal').on('click', function () {
        $('.modal').modal('hide');
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
function formDataLoad(domId, obj) {
    for (var property in obj) {
        if (obj.hasOwnProperty(property) == true) {
            if ($("#" + domId + " [name='" + property + "']").size() > 0) {
                $("#" + domId + " [name='" + property + "']").each(function () {
                    var dom = this;
                    if ($(dom).attr("type") == "radio") {
                        $(dom).filter("[value='" + obj[property] + "']").attr("checked", true);
                    }
                    else if ($(dom).attr("type") == "checkbox") {
                        obj[property] == true ? $(dom).attr("checked", "checked") : $(dom).attr("checked", "checked").removeAttr("checked");
                    }
                    else if ($(dom).attr("type") == "text" || $(dom).prop("tagName") == "SELECT" || $(dom).attr("type") == "hidden" || $(dom).attr("type") == "textarea") {
                        $(dom).val(obj[property]);
                    }
                    else if ($(dom).prop("tagName") == "TEXTAREA") {
                        $(dom).val(obj[property]);
                    } else {
                        $(dom).val(obj[property]);
                    }
                });
            }
        }
    }
}

function alertDialog(title, content) {
    $('#myModalLabel').text(title);
    $('#content').text(content);
    $('#myModal').modal('show');
}
function dismissDialog() {
    $('#myModal').modal('hide');
}