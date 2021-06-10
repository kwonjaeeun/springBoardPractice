<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <form action="writeMod" method="POST">
            <div><input type="hidden" name="iboard" value="${requestScope.data.iboard}"></div>
            <div><input type="text" name="title" placeholder="Title" value="${requestScope.data.title}"></div>
            <div><textarea name="ctnt" placeholder="Content">${requestScope.data.ctnt}</textarea> </div>
            <div>
                <c:choose>
                    <c:when test="${data.iboard eq 0}">
                        <input type="submit" value="Write">
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Mod">
                    </c:otherwise>
                </c:choose>
                <input type="reset" value="Reset">
            </div>
    </form>
