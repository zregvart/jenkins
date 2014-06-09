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
<tr><td>*</td><td>hetero-list</td><td>*</td><td>includes descriptor config pages expecting <code>tr</code> children</td></tr>
<tr><td>*</td><td>hetero-radio</td><td>N/A</td><td>includes descriptor config pages expecting <code>tr</code> children</td></tr>
<tr><td>table</td><td>invisibleEntry</td><td>*</td><td></td></tr>
<tr><td>table</td><td>nested</td><td>*</td><td></td></tr>
<tr><td>*</td><td>number</td><td>N/A</td><td></td></tr>
<tr><td>select</td><td>option</td><td>CDATA or other text</td><td></td></tr>
<tr><td>table</td><td>optionalBlock</td><td>tr</td><td></td></tr>
<tr><td>table</td><td>optionalProperty</td><td>N/A</td><td>includes descriptor config pages expecting <code>tr</code> children</td></tr>
<tr><td>*</td><td>password</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>prepareDatabinding</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>property</td><td>N/A</td><td>includes descriptor config pages expecting <code>tr</code> children</td></tr>
<tr><td>*</td><td>radio</td><td>N/A</td><td></td></tr>
<tr><td>table</td><td>radioBlock</td><td>tr</td><td></td></tr>
<tr><td>*</td><td>readOnlyTextbox</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>repeatable</td><td>*</td><td></td></tr>
<tr><td>*</td><td>repeatableDeleteButton</td><td>N/A</td><td></td></tr>
<tr><td>*</td><td>repeatableHeteroProperty</td><td>N/A</td><td>includes descriptor config pages expecting <code>tr</code> children</td></tr>
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

## Tag structure to convert

    <table>
        <!-- start f:entry -->
        <tr>
          <td class="setting-leftspace">&nbsp;</td>
          <td class="setting-name">...</td>
          <td class="setting-main">...</td>
          <td class="setting-help"><a class="help-button"><img/></a></td>
        </tr>
        <tr class=validation-error-area>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td colspan="2"></td>
          <td class="setting-description">...</td>
        </tr>
        <tr class="help-area">
          <td/>
          <td colspan="2">
            <div class="help">...</div>
          </td>
          <td/>
        </tr>
        <!-- end f:entry -->
    </table>

## Tag structure to convert to

    <div class="setting-form">
        <!-- start f:entry -->
        <div class="setting-entry">
          <div class="setting-leftspace">&nbsp;</div>
          <div class="setting-name">...</div>
          <div class="setting-main">...</div>
          <div class="setting-help"><a class="help-button"><img/></a></div>
          <div class=validation-error-area></div>
          <div class="setting-description">...</div>
          <div class="help-area">
            <div class="help">...</div>
          </div>
        </div>
        <!-- end f:entry -->
    </div>
