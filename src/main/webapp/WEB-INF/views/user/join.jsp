<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>join</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="join" method="post">
        <div>
            <input type="text" name="uid" placeholder="id">
        </div>
        <div>
            <input type="password" name="upw" placeholder="password">
        </div>
        <div>
            <input type="text" name="unm" placeholder="name">
        </div>
        <div>
            Gender: <label>Female<input type="radio" name="gender"
                                        value="0" checked="checked"></label> <label>Male<input
                type="radio" name="gender" value="1"></label>
        </div>
        <div>
            <input type="submit" value="join">
        </div>
    </form>


</body>
</html>
