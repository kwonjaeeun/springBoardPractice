<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listss</title>
</head>
<body>
<h1>리스트</h1>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일시</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr class="record" onclick="moveToDetail(${item.iboard});">
            <td>${item.iboard}</td>
            <td>
                <c:choose>
                    <c:when test="${searchType eq 1 || searchType eq 2}">
                        ${item.title.replace(searchText, '<mark>' += searchText += '</mark>')}
                    </c:when>
                    <c:otherwise>
                        ${item.title}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${searchType eq 4}">
                        ${item.writerNm.replace(searchText, '<mark>' += searchText += '</mark>')}
                    </c:when>
                    <c:otherwise>
                        ${item.writerNm}
                    </c:otherwise>
                </c:choose>

            </td>
            <td>${item.regdt}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
