<#import "parts/pageTemplate.ftl" as pt>



<@pt.page>
    <h2>Search</h2>
    <form method="get" action="cars">
        <input type="text" name="nameFilter" placeholder="Name" value="${nameFilter!}">
        <input type="text" name="cellFilter" placeholder="Cell" value="${cellFilter!}">
        <input type="submit" value="Search">
    </form>
    <#include "parts/carParts/carList.ftl">
</@pt.page>