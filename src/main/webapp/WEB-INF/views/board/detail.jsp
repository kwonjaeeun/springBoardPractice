<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div><a href="#" onclick="goBack();">돌아가기</a></div>
<div>
    <a href="/board/writeMod?iboard=${requestScope.data.iboard}">수정</a>
    <a href="/board/delBoard?iboard=${requestScope.data.iboard}">삭제</a>
</div>
<h1>${requestScope.data.title}</h1>
<div><button onclick="fav()">하트모양넣었다고 생각하고~</button></div>
<div id="fav" data-fav="${0}">...</div>
<div>글번호 : ${requestScope.data.iboard}</div>
<div>작성자 : <c:out value="${requestScope.data.writerNm}"/> | 작성일 : ${requestScope.data.regdt}</div>
<div><c:out value="${requestScope.data.ctnt}"/></div>
<c:if test="${not empty sessionScope.loginUser}">
    <div>
        <form id="cmtFrm" onsubmit="return false;">
            <input type="text" id="ctnt">
            <input type="button" value="댓글달기" onclick="regCmt();">
        </form>
    </div>
</c:if>

<div id="cmtList" data-login-user-pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>
<div id="modal" class="displayNone">
    <div class="modal_content">
        <form id="cmtModFrm" action="#">
            <input type="hidden" id="icmt">
            <input type="text" id="cmt">
        </form>
        <input type="button" value="댓글 수정" onclick="modAjax();">
        <input type="button" value="취소" onclick="closeModModal();">
    </div>
</div>

<script src="/res/js/board/detail.js"></script>
