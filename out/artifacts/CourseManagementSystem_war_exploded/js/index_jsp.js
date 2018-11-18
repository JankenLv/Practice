
// var loginStatus = false;

function login() {
    var username = $("[name=username]").val(),
        password = $("[name=password]").val(),
        checkCode = $("[name=checkCode]").val(),
        loginStatus = false;
    if (!(username === "" || password === "" || checkCode === "")) {
        $.ajax({
            url:"checkLoginInfo",
            data:{
                username:username,
                password:password,
                checkCode:checkCode
            },
            async : false,
            success:function (result) {
                if (result === "loginSuccess" ) {
                    loginStatus = true;
                }else if (result !== "") {
                    loginStatus = false;
                    console.log(result);
                    $("#msg").empty().html(result).fadeIn("slow").delay(2000).fadeOut("slow");
                    $("#checkCode").attr("src","kaptcha.jpg?time=" + new Date().getMilliseconds());
                    // loginStatus = false;
                }
            }
        });
    }
    return loginStatus;
}

// 点击图片更换验证码
function changeKaptcha() {
    $("#checkCode").attr("src","kaptcha.jpg?time=" + new Date().getMilliseconds());
}

function checkLoginStatus() {
    // console.log(loginStatus);
    return login();
}

