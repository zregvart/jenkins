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
</thead>
<tbody>
<tr><td>table</td><td>advanced</td><td>tr</td></tr>
<tr><td>*</td><td>apply</td><td>N/A</td></tr>
<tr><td>table</td><td>block</td><td>*</td></tr>
<tr><td>*</td><td>booleanRadio</td><td>N/A</td></tr>
<tr><td>table</td><td>bottomButtonBar</td><td>*</td></tr>
<tr><td>table</td><td>breadcrumb-config-outline</td><td></td></tr>
<tr><td>*</td><td>checkbox</td><td>N/A</td></tr>
<tr><td>*</td><td>combobox</td><td>N/A</td></tr>
<tr><td>table</td><td>description</td><td>*</td></tr>
<tr><td></td><td>descriptorList</td><td></td></tr>
<tr><td></td><td>descriptorRadioList</td><td></td></tr>
<tr><td></td><td>dropdownDescriptorSelector</td><td></td></tr>
<tr><td></td><td>dropdownList</td><td></td></tr>
<tr><td></td><td>dropdownListBlock</td><td></td></tr>
<tr><td></td><td>editableComboBox</td><td></td></tr>
<tr><td></td><td>editableComboBoxValue</td><td></td></tr>
<tr><td>table</td><td>entry</td><td>*</td></tr>
<tr><td></td><td>enum</td><td></td></tr>
<tr><td></td><td>enumSet</td><td></td></tr>
<tr><td></td><td>expandableTextbox</td><td></td></tr>
<tr><td>*</td><td>form</td><td></td></tr>
<tr><td></td><td>helpArea</td><td></td></tr>
<tr><td></td><td>hetero-list</td><td></td></tr>
<tr><td></td><td>hetero-radio</td><td></td></tr>
<tr><td></td><td>invisibleEntry</td><td></td></tr>
<tr><td></td><td>nested</td><td></td></tr>
<tr><td></td><td>number</td><td></td></tr>
<tr><td></td><td>option</td><td></td></tr>
<tr><td></td><td>optionalBlock</td><td></td></tr>
<tr><td></td><td>optionalProperty</td><td></td></tr>
<tr><td></td><td>password</td><td></td></tr>
<tr><td></td><td>prepareDatabinding</td><td></td></tr>
<tr><td></td><td>property</td><td></td></tr>
<tr><td></td><td>radio</td><td></td></tr>
<tr><td></td><td>radioBlock</td><td></td></tr>
<tr><td></td><td>readOnlyTextbox</td><td></td></tr>
<tr><td></td><td>repeatable</td><td></td></tr>
<tr><td></td><td>repeatableDeleteButton</td><td></td></tr>
<tr><td></td><td>repeatableHeteroProperty</td><td></td></tr>
<tr><td></td><td>repeatableProperty</td><td></td></tr>
<tr><td></td><td>richtextarea</td><td></td></tr>
<tr><td>table</td><td>rowSet</td><td>tr</td></tr>
<tr><td>table</td><td>section</td><td>tr</td></tr>
<tr><td></td><td>select</td><td></td></tr>
<tr><td></td><td>slave-mode</td><td></td></tr>
<tr><td></td><td>submit</td><td></td></tr>
<tr><td></td><td>textarea</td><td></td></tr>
<tr><td></td><td>textbox</td><td></td></tr>
<tr><td></td><td>validateButton</td><td></td></tr>
<tr><td>*</td><td>withCustomDescriptorByName</td><td>*</td></tr></tbody>
</table>