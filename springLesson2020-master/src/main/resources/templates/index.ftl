<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <h1>Hello, <#if user??>${name}<#else>Guest</#if> </h1>
</@pt.page>