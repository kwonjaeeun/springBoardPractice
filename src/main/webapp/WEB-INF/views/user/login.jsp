<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="login" method="post">
        <div>
            Id:<input type="text" name="uid">
        </div>
        <div>
            Password:<input type="password" name="upw">
        </div>
        <div>
            <input type="hidden" name="address" value="${address}">
            <input type="submit" id="log_button" value="Login"> <input
                type="reset" value="Reset">
        </div>
        <div>${errmsg}</div>
    </form>
    <div>
        <a href="join" style="text-decoration: none">SIGNIN</a>
    </div>
</body>
</html>
