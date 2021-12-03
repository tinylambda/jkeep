x: ${x}, y: ${y}
<#list items as item>
    ====> ${item}
    <#if item_has_next>has more<#else >no more</#if>
</#list>

<#list items as item>
    ${item}
    <#if item?is_first>(I am first)</#if>
    <#if item?is_last>(I am last)</#if>
</#list>
