
var validateUserNameResult;

// 验证用户名是否已存在
function validateUserName() {
    var inputUserName = $("[name=username]");
    var username = inputUserName.val();
    if (username !== undefined && username !== "") {
        $.get(
            "validateUserName",
            {username: username},
            function (result) {
                // console.log("result: " + result);
                var validateMsg = $("#validateUsernameMsg");
                if (result === "1") {
                    validateUserNameResult = false;
                    validateMsg.html("该名称已被使用！");
                    inputUserName.css("border", "1px solid red");
                } else if (result === "-1") {
                    validateUserNameResult = true;
                    validateMsg.empty();
                    inputUserName.css("border", "1px solid black");
                }
            }
        );
    }
}

// 验证账户信息格式
function validateCode() {
    var username = $("[name=username]").val(),
        password = $("[name=password]").val();
    return /^\w{3,12}$/.test(username)&&/^\w{5,12}$/.test(password);
}

function validateForm() {
    return validateUserNameResult&&validateCode();
}
