<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
Menu
<ul>
    <c:forEach items="${allGenre}" var="genre">
        <li>
            <spring:url value="/${genre.name}" var="${genre.name}" htmlEscape="true"/>
            <a href="${genre.name}">${genre.name}</a>
        </li>
    </c:forEach>
</ul>
</div>

