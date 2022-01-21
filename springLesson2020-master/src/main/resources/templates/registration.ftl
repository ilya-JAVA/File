<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <form method="post">
    <input type="hidden" name="id"
           value="<#if user?? && user.id??>${user.id}</#if>"/>
    <input type="text" name="username" placeholder="username"
           class="form-control ${(usernameError??)?string('is-invalid', '')}"
           value="<#if user?? && user.username??>${user.username}</#if>"/>
    <#if usernameError??>
      <div class="invalid-feedback">
        ${usernameError}
      </div>
    </#if>
    <input type="password" name="password" placeholder="password"
           class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
      <#if passwordError??>
        <div class="invalid-feedback">
            ${passwordError}
        </div>
      </#if>
    <input type="password" name="passwordConfirm" placeholder="password"
           class="form-control ${(passwordConfirmError??)?string('is-invalid', '')}"/>
      <#if passwordConfirmError??>
        <div class="invalid-feedback">
            ${passwordConfirmError}
        </div>
      </#if>
    <input type="email" name="email" placeholder="email"
           class="form-control ${(emailError??)?string('is-invalid', '')}"
           value="<#if user?? && user.email??>${user.email}</#if>"/>
    <#if emailError??>
      <div class="invalid-feedback">
        ${emailError}
      </div>
    </#if>
    <input type="text" name="firstName" placeholder="firstName"
           class="form-control ${(firstNameError??)?string('is-invalid', '')}"
           value="<#if user?? && user.firstName??>${user.firstName}</#if>"/>
    <input type="text" name="lastName" placeholder="lastName"
           class="form-control ${(lastNameError??)?string('is-invalid', '')}"
           value="<#if user?? && user.lastName??>${user.lastName}</#if>"/>
    <input type="text" name="surname" placeholder="surname"
           class="form-control ${(surnameError??)?string('is-invalid', '')}"
           value="<#if user?? && user.surname??>${user.surname}</#if>"/>
<#--    <input type="date" name="birthday"-->
<#--           class="form-control ${(birthdayError??)?string('is-invalid', '')}"-->
<#--           value="<#if user?? && user.birthday??>${user.birthday}</#if>">-->
    <button type="submit">Registration</button>
  </form>

<#--    <#list users as user>-->
<#--      <p>-->
<#--        <a href="/registration?editUser=${user.id}">${user.id}</a>-->
<#--      </p>-->
<#--    </#list>-->
</@pt.page>