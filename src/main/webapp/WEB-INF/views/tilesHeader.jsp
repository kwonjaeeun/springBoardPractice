<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul id="headerUl">
        <c:choose>
            <c:when test="${empty sessionScope.loginUser}">
                <li><a href="/user/login">로그인</a></li>
            </c:when>
            <c:otherwise>
                <li><a>${sessionScope.loginUser.unm}님</a></li>
                <li><a href="/user/login">로그아웃</a></li>
            </c:otherwise>
        </c:choose>
                <li><a href="/">home</a></li>
                <li><a href="/board/list">LIST</a></li>
        <c:if test="${not empty sessionScope.loginUser}">
            <li><a href="/board/writeMod?iboard=0">write</a></li>
            <li><a href="/user/profile">profie</a></li>
        </c:if>
    </ul>
</header>
