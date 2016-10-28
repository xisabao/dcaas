# Survey Renderer Specification

## File format

Supported HTML tags, including all supported parameters:
```xml
<h1>, <h2>, <h3>, <h4>, <h5>, <h6>
<b>, <i>, <u>
<a href="">
<code>
<br>, <hr>
<ul>, <ol>, <li>
<p>
<sub>, <sup>
<!-- -->
```

Supported tags that do not appear in HTML:
```
<short-answer name="">
<long-answer name="">
<checkboxes name="">, <option value="">
<datepicker name="">
<timepicker name="">
<natural-language-date-time name="">
<multiple-choice name="">, <option value="">
<linear-scale name="">, <option value="">
<multiple-choice-grid name="">, <row name="">, <column value="">
<dropdown name="">, <option value="">
<unsafe>
```

The following is an example format for a survey:
```xml
<!DOCTYPE survey>
<survey name="MYSURVEY">
  <!-- A subset of HTML can be used, including <h1>. -->
  <h1>Title of Survey</h1>

  <!-- A short answer is a single line of text. The name
       parameter corresponds with the name that will be
       used in the database to reference this piece of
       data. -->
  <short-answer name="MYSHORTANSWER">Write your short
    answer prompt here.</short-answer>

  <!-- A long answer spans multiple lines -->
  <long-answer name="MYLONGANSWER">Write your long
    answer prompt here.</long-answer>

  <!-- Multiple checkboxes can be selected at once. The
       option tags specifies each of the options that the
       user can select from. The value parameter specifies
       how the data will be represented in the database.
       Warning: this will create a column in your database
       per option with the value as either true or false. -->
  <checkboxes name="MYCHECKBOXES">
    Write your checkboxes prompt here.
    <option value="bob">Bob</option>
    <option value="alice">Alice</option>
    <option value="eve">Eve</option></checkboxes>

  <!-- Picks the data with a nice UI. -->
  <datepicker name="MYDATEPICKER">Write your datepicker
    prompt here.</datepicker>

  <!-- Picks the time or a time duration with a nice UI. -->
  <timepicker name="MYTIMEPICKER">Write your timepicker
    prompt here.</timepicker>

  <!-- Parses natural language to understand when a user
       enters a date, a time, or a time duration (or more
       than one.) -->
  <natural-language-date-time name="MYNATLANGDATETIME">
    Write your natural language date-time prompt here.
    </natural-language-date-time>

  <!-- A multiple choice only allows the user to select one
       option of all possible. -->
  <multiple-choice name="MYMULTIPLECHOICE">
    Write your multiple choice prompt here.
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option></multiple-choice>

  <!-- Similar to a multiple choice, but renders horizontally. -->
  <linear-scale name="MYLINEARSCALE">
    Write your linear scale prompt here.
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option></linear-scale>

  <!-- A compact list of multiple choice questions with the
       same options for all of them. The row element specifies
       a prompt, a column is a possible value. -->
  <multiple-choice-grid name="MYMULTIPLECHOICEGRID">
    Write your multiple choice grid prompt here.
    <row name="question1">Question 1?</row>
    <row name="question2">Question 2?</row>
    <column value="yes">Yes</column>
    <column value="maybe">Maybe</column>
    <column value="no">No</column></multiple-choice-grid>

  <!-- Dropdowns are similar to a multiple choice, but the
       options are rendered as an HTML dropdown menu. -->
  <dropdown name="MYDROPDOWN">
    Write your dropdown prompt here.
    <option value="arkansas">Arkansas</option>
    <option value="mississippi">Mississippi</option>
    <option value="washington">Washington</option></dropdown>
</survey>
```

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <h1>Title</h1>
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label for="short-answer">Short answer</label>
    <input type="text" class="form-control" id="short-answer">
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label for="long-answer">Long answer</label>
    <textarea class="form-control" rows="3" id="long-answer"></textarea>
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label>Checkboxes (check all that apply)</label><br>
      <input type="checkbox" value=""> First option<br>
      <input type="checkbox" value=""> Second option<br>
      <input type="checkbox" value=""> Third Option<br>
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label>Datepicker</label><br>
    <div><input type="text" class="datepicker"></div>
  </div>
  <div class="col-md-3"></div>
</div>
<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label for="natural-language-date-time">Natural language processed date/time</label>
    <br><i>4:30 PM. May 1, 2016</i><br>
    <input type="text" class="form-control" placeholder="at 430pm on may 1, 2016" id="natural-language-date-time">
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label>Multiple Choice, choose 1</label><br>
    <input type="radio" name="multiple-choice" value=""> First Option<br>
    <input type="radio" name="multiple-choice" value=""> Second Option<br>
    <input type="radio" name="multiple-choice" value=""> Third Option
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
  <label for="natural-language-duration">Natural language processed duration</label><br>
  <i>3 hours, 17 minutes</i><br>
  <input type="text" class="form-control" placeholder="3h 17m" id="natural-language-duration">
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<label>Linear scale</label><br>
<label class="linear-scale-labels"><span class="linear-scale-label">1</span><span class="linear-scale-label"> 2</span><span class="linear-scale-label"> 3</span></label><br>
 <div class="linear-scale-radio-wrapper"><input type="radio" value="1" name="linear-scale" class="linear-scale-radio"></div>
 <div class="linear-scale-radio-wrapper"> <input type="radio" value="2"  name="linear-scale" class="linear-scale-radio"> </div>
  <div class="linear-scale-radio-wrapper"><input type="radio" value="3"  name="linear-scale" class="linear-scale-radio"> </div>
</div>
<div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
  <label>Multiple Choice Grid</label>
    <table>
      <tr>
        <td class="mc-grid"></td>
        <td class="mc-grid">Column 1</td>
        <td class="mc-grid">Column 2</td>
        <td class="mc-grid">Column 3</td>
      </tr>
      <tr>
        <td class="mc-grid">Question 1</td>
        <td class="mc-grid"><input type="radio" value="1" name="row-1"></td>
        <td class="mc-grid"><input type="radio" value="2" name="row-1"></td>
        <td class="mc-grid"><input type="radio" value="3" name="row-1"></td>
      </tr>
      <tr>
        <td class="mc-grid">Question 2</td>
        <td class="mc-grid"><input type="radio" value="1" name="row-2"></td>
        <td class="mc-grid"><input type="radio" value="2" name="row-2"></td>
        <td class="mc-grid"><input type="radio" value="3" name="row-2"></td>
      </tr>          
    </table>
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label>Dropdown</label><br>
    <select>
      <option value="1">Option 1</option>
      <option value="2">Option 2</option>
      <option value="3">Option 3</option>
    </select>
  </div>
  <div class="col-md-3"></div>
</div>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
    <label>Slider</label><br>
    <input type="text" class="slider-amount" readonly>
    <div class="slider"></div>
  </div>
  <div class="col-md-3"></div>
</div>
