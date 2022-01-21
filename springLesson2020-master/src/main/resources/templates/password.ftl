<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

<@pt.page>
  <form method="post" action="/user/password">
    <input type="password" name="oldPassword" class="form-control ${(oldPasswordError??)?string('is-invalid', '')}">
      <#if oldPasswordError??>
        <div class="invalid-feedback">
            ${oldPasswordError}
        </div>
      </#if>
    <input type="password" name="newPassword" class="form-control ${(newPasswordError??)?string('is-invalid', '')}">
      <#if newPasswordError??>
        <div class="invalid-feedback">
            ${newPasswordError}
        </div>
      </#if>
    <input type="password" name="confirmPassword" class="form-control ${(confirmPasswordError??)?string('is-invalid', '')}">
      <#if confirmPasswordError??>
        <div class="invalid-feedback">
            ${confirmPasswordError}
        </div>
      </#if>
    <button class="btn btn-info">Change</button>
  </form>
</@pt.page>