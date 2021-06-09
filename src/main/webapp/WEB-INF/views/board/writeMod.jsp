<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
    <form action="writeMod" method="POST">
            <div><input type="hidden" name="iboard" value="0"></div>
            <div><input type="text" name="title" placeholder="Title"></div>
            <div><textarea name="ctnt" placeholder="Content"></textarea> </div>
            <div>
                <input type="submit" value="Write">
                <input type="reset" value="Reset">
            </div>
    </form>
</form>