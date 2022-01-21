<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <div class="container">
    <form method="post" action="/user/email" class="form-group">
      <input type="email" name="oldEmail" placeholder="Old email"
             class="form-control ${(oldEmailError?? || oldEmailEmpty??)?string('is-invalid', '')}"
             value="<#if oldEmail??>${oldEmail}</#if>"/>
        <#if oldEmailError??>
          <div class="invalid-feedback">
              ${oldEmailError}
          </div>
        </#if>
        <#if oldEmailEmpty??>
          <div class="invalid-feedback">
              ${oldEmailEmpty}
          </div>
        </#if>
      <input type="email" name="newEmail" placeholder="New email"
             class="form-control ${(newEmailError?? || newEmailUnique??)?string('is-invalid', '')}"
             value="<#if newEmail??>${newEmail}</#if>"/>
        <#if newEmailError??>
          <div class="invalid-feedback">
              ${newEmailError}
          </div>
        </#if>
        <#if newEmailUnique??>
          <div class="invalid-feedback">
              ${newEmailUnique}
          </div>
        </#if>
      <input type="submit" class="btn btn-info" value="Submit" />
    </form>
  </div>
</@pt.page>