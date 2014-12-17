<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
    Menu
    <ul>
        <li>
            <spring:url value="/${book.title}" var="${book.title}"/>
            <a href="${book.title}">${book.title}</a>
        </li>
    </ul>
</div>

