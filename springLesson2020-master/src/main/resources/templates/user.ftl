<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

<@pt.page>
  <p>${user.username}</p>
  <p>${user.firstName}</p>
  <p>${user.lastName}</p>
  <p>${user.surname}</p>
  <p>${user.email}<a href="/user/email"><button class="btn btn-info">change email</button></a></p>
  <p><a href="/user/password">Сменить пароль</a></p>
</@pt.page>