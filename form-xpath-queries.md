# Form XPath queries

In order to switch to from tables to divs we need to retain the context information of the form tags so that we can construct XPath
queries to identify plugins that have jelly files not using the /lib/form jelly tags.

## Contexts

The following table records the form tags and their contextual locations

<table>
<thead>
<th>Parent assumed to be a _ element</th>
<th>Tag</th>
<th>Child assumed to be _ element(s)</th>
<th>Notes</th>
</thead>
<tbody>
<tr><td>table</td><td>advanced</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>apply</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>block</td><td>*</td><td></td></tr>
<tr><td>*</td><td>booleanRadio</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>bottomButtonBar</td><td>*</td><td></td></tr>
<tr><td>table</td><td>breadcrumb-config-outline</td><td></td><td></td></tr>
<tr><td>*</td><td>checkbox</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>combobox</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>description</td><td>*</td><td></td></tr>
<tr><td>table</td><td>descriptorList</td><td>tr</td><td></td></tr>
<tr><td>table</td><td>descriptorRadioList</td><td>tr</td><td></td></tr>
<tr><td>table</td><td>dropdownDescriptorSelector</td><td>when <code>dropdownListMode=='createSelectField'</code> then <code>option</code><br/>when <code>dropdownListMode=='generateEntries'</code> then <code>tr</code></td><td></td></tr>
<tr><td>table</td><td>dropdownList</td><td>when <code>dropdownListMode=='createSelectField'</code> then <code>option</code><br/>when <code>dropdownListMode=='generateEntries'</code> then <code>tr</code></td><td></td></tr>
<tr><td>when <code>dropdownListMode=='createSelectField'</code> then <code>select</code><br/>when <code>dropdownListMode=='generateEntries'</code> then <code>table</code></td><td>dropdownListBlock</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>editableComboBox</td><td>*</td><td></td></tr>
<tr><td>*</td><td>editableComboBoxValue</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>entry</td><td>*</td><td></td></tr>
<tr><td>*</td><td>enum</td><td>CDATA or other text</td><td></td></tr>
<tr><td>*</td><td>enumSet</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>expandableTextbox</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>form</td><td>tr</td><td></td></tr>
<tr><td>table</td><td>helpArea</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>hetero-list</td><td>*</td><td></td></tr>
<tr><td>*</td><td>hetero-radio</td><td>N/A</td><td></td></tr>
<tr><td></td><td>invisibleEntry</td><td></td><td></td></tr>
<tr><td>table</td><td>nested</td><td>*</td><td></td></tr>
<tr><td></td><td>number</td><td></td><td></td></tr>
<tr><td></td><td>option</td><td></td><td></td></tr>
<tr><td></td><td>optionalBlock</td><td></td><td></td></tr>
<tr><td></td><td>optionalProperty</td><td></td><td></td></tr>
<tr><td></td><td>password</td><td></td><td></td></tr>
<tr><td>*</td><td>prepareDatabinding</td><td>N/A</td><td></td></tr>
<tr><td></td><td>property</td><td></td><td></td></tr>
<tr><td></td><td>radio</td><td></td><td></td></tr>
<tr><td>table</td><td>radioBlock</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>readOnlyTextbox</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>repeatable</td><td>*</td><td></td></tr>
<tr><td>*</td><td>repeatableDeleteButton</td><td>N/A</td><td></td></tr>
<tr><td></td><td>repeatableHeteroProperty</td><td></td><td></td></tr>
<tr><td>*</td><td>repeatableProperty</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>richtextarea</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>rowSet</td><td>tr</td><td></td></tr>
<tr><td>table</td><td>section</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>select</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>slave-mode</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>submit</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>textarea</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>textbox</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>validateButton</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>withCustomDescriptorByName</td><td>*</td><td></td></tr></tbody>
</table>