<html>
<body>
<pre>
    Hello freemarker!

    <#-- You can not see me -->
    ${value1}
    ${value2!}
    <#list colors as color>
        ${color_index} -- ${color}
        <#if color = "Green">Green will stop this loop! Be careful!<#break/></#if>
    </#list>

    <#list map as key, value>
        ${key} = ${value}
    </#list>


</pre>
</body>
</html>
