<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <h2>Add car for ${user.firstName} ${user.surname} ${user.lastName}</h2>
  <form method="post">
      <#if carError?? && carError?has_content><div style="color:red">${carError}</div></#if>
    <input type="hidden" name="id"
           value="<#if car?? && car.id??>${car.id}</#if>"/>
    <input type="text" name="name" placeholder="Name"
           class="form-control ${(nameError??)?string('is-invalid', '')}"
           value="<#if car?? && car.name??>${car.name}</#if>"/>
    <input type="text" name="cell" placeholder="cell"
           class="form-control ${(speciesError??)?string('is-invalid', '')}"
           value="<#if car?? && car.cell??>${car.cell}</#if>" />
    <input type="text" name="color" placeholder="color"
           class="form-control ${(sexError??)?string('is-invalid', '')}"
           value="<#if car?? && car.color??>${car.sex}</#if>" />
    <input type="date" name="birth"
           class="form-control ${(birthError??)?string('is-invalid', '')}"
           value="<#if car?? && car.birth??>${car.birth}</#if>">
    <input type="hidden" name="carOwner"
           class="form-control ${(animalOwnerError??)?string('is-invalid', '')}"
           value="<#if user??>${user.id}</#if>" />
    <button type="submit" style="color: black"><#if animal??>Edit<#else>Add</#if></button>
  </form>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Cell</th>
      <th>Color</th>
      <th>isDelete</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tbody>
    <#list cars as car>
      <tr ${car.deleted?then('class="alert-danger"', "")}>
        <td>${car.id}</td>
        <td>${car.name}</td>
        <td>${car.cell}</td>
        <td>${car.color}</td>
        <td><#if car.deleted??>
                ${car.deleted?then("true", "false")}
            </#if></td>
        <td><a href="/cars?editAnimal=${car.id}">edit</a></td>
        <td>${animal.deleted?then('<a href="/cars?repairId=${animal.id}">repair</a>', '<a href="/cars?removeId=${animal.id}">remove</a>')}</td>
      </tr>
    </#list>
    </tbody>
  </table>
</@pt.page>