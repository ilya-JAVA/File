<h2>Search</h2>
<form method="get" action="cars">
	<input type="text" name="nameFilter" placeholder="Name" value="${nameFilter!}">
	<input type="text" name="cellFilter" placeholder="Cell" value="${cellFilter!}">
	<input type="submit" value="Search">
</form>

<h2>Add car</h2>
<form method="post">
    <#if carError?? && carError?has_content><div style="color:red">${carError}</div></#if>
<input type="hidden" name="id"
       value="<#if car?? && car.id??>${car.id}</#if>"/>
<input type="text" name="name" placeholder="Name"
       class="form-control ${(carError??)?string('is-invalid', '')}"
       value="<#if car?? && car.name??>${car.name}</#if>"/>
<input type="text" name="cell" placeholder="cell"
       class="form-control ${(cellError??)?string('is-invalid', '')}"
       value="<#if car?? && car.cell??>${car.cell}</#if>" />
<input type="text" name="color" placeholder="color"
       class="form-control ${(colorError??)?string('is-invalid', '')}"
       value="<#if car?? && car.color??>${car.color}</#if>" />
<button type="submit" style="color: black"><#if car??>Edit<#else>Add</#if></button>
</form>
