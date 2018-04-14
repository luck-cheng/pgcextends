$(function () {
    var bg = chrome.extension.getBackgroundPage();
    var btn = $("#startbtn");
    var loginbtn = $("#loginbtn");
    loginbtn.hide();
    $("#loginForm").hide()
    $("#error_msg").hide()


    //查询当前pop状态
    bg.popAction(1000).then(function (code) {

        switch (code) {
            case 0:
            case -1:
                btn.attr('disabled', 'disabled');
                btn.attr('value', '检测服务');
                break;
            case 1:
                var bg = chrome.extension.getBackgroundPage();
                if(bg.getStorage()){
                    if(bg.getClickState() === 1){
                        btn.attr('disabled', 'disabled');
                        btn.attr('value', '正在抓取');
                    }else {
                        btn.removeAttr('disabled');
                        btn.attr('value', '开始抓取');
                        btn.click(function () {
                            btn.attr('disabled', 'disabled');
                            btn.attr('value', '正在抓取');
                            // content init ok & can click
                            bg.popAction(2000)
                        });
                    }
                }else {
                    btn.hide();
                    loginbtn.show();
                    loginbtn.click(function () {
                        loginbtn.hide();
                        $("#loginForm").show();
                        $("#textForm").show();
                        $("#error_msg").hide();
                    })
                }
                break;
            default :
                break;
        }
    });

    $("#backbtn").click(function () {
        $("#loginForm").hide();
        loginbtn.show();
    })

    $("#confirmId").click(function () {
        $.ajax({
            url: "http://127.0.0.1:7000/getToken",
            type: "POST",
            dataType: "JSON",
            data:{
                username : $("#usernameId").val(),
                password : $("#passwordId").val()
            },
            success : function (json) {
                if(json.code === 200){
                    var bg = chrome.extension.getBackgroundPage();
                    bg.setStorage(json.XToken);
                    btn.removeAttr('disabled');
                    btn.attr('value', '开始抓取');
                    $("#loginForm").hide();
                    btn.show();
                    btn.click(function () {
                        btn.attr('disabled', 'disabled');
                        btn.attr('value', '正在抓取');
                        // content init ok & can click
                        bg.popAction(2000)
                    });
                }else if(json.code === 500){
                    $("#textForm").hide();
                    $("#error_msg").show();
                }
            }
        })
    })

});

