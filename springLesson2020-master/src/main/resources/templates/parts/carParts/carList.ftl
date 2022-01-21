<#import "../pager.ftl" as p>

<h1>Our cars</h1>
<#if hasContent>
<@p.pager url page/>
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
  <#list page.content as car>
		<tr ${car.deleted?then('class="alert-danger"', "")}>
			<td>${car.id}</td>
			<td>${car.name}</td>
			<td>${car.cell}</td>
			<td>${car.color}</td>
			<td><#if car.deleted??>
              ${car.deleted?then("true", "false")}
          </#if></td>
			<td><a href="/cars?Car=${car.id}">edit</a></td>
			<td>${car.deleted?then('<a href="/cars?repairId=${animal.id}">repair</a>', '<a href="/cars?removeId=${animal.id}">remove</a>')}</td>
		</tr>
  </#list>
	</tbody>
</table>
<@p.pager url page/>
<#else>
		<b>No cars!</b>
</#if>

