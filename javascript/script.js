function addElements(event) {
   
    removeElements();
    
    if (this.options[this.selectedIndex].text == "Rajasthan") {
        addDomainName();
        addProjectDesc()

    } else if (this.options[this.selectedIndex].text == "Haryana") {
        addZipCode();
        addHosting();

    } else if (this.options[this.selectedIndex].text == "Maharashtra") {
        addZipCode();
        addProjectDesc();
    }
}



function addProjectDesc() {
     debugger;
    var div = document.createElement('div');

    div.className = 'main optionalElement';

    div.innerHTML = '<div class="input-row">\
                    <div class="label">Project Description</div>\
     <div class="icon-field-container">\
<div class="textarea-field-icon"><i class="fa fa-pen"></i></div>\
<div class="input-field">\
<textarea id="projectDesc" name="projectDesc" placeholder="Project Description"></textarea></div></div></div>';

    document.getElementById('fields').appendChild(div);
}

function addZipCode() {

    var div = document.createElement('div');

    div.className = 'main optionalElement';

    div.innerHTML = '<div class="input-row">\
                <div class="label">\
                    Zip Code\
                </div>\
                <div class="icon-field-container">\
                    <div class="field-icon">\
                        <i class="fa fa-home"></i>\
                    </div>\
                    <div class="input-field">\
                        <input type="text" id="zipcode" name="zipcode" required\ placeholder="Zip Code">\
                    </div>\
                </div>\
            </div>';

    document.getElementById('fields').appendChild(div);

}

function addHosting() {

    var div = document.createElement('div');

    div.className = 'main optionalElement';

    div.innerHTML = '<div class="input-row">\
                <div class="label">\
                    Do you have hosting?\
                </div>\
                <div class="icon-field-container">\
                    <div class="input-field">\
                        <input type="radio" id="hosting" name="hosting" value="yes">Yes\
                        <br>\
                        <input type="radio" id="hosting" name="hosting" value="no">No\
                    </div>\
                </div>\
            </div>';

    document.getElementById('fields').appendChild(div);

}

function addDomainName() {

    var div = document.createElement('div');

    div.className = 'main optionalElement';

    div.innerHTML = '<div class="input-row">\
                <div class="label">\
                    Website or domain name\
                </div>\
                <div class="icon-field-container">\
                    <div class="field-icon">\
                        <i class="fa fa-globe-asia"></i>\
                    </div>\
                    <div class="input-field">\
                        <input type="url" id="domainName" name="domainName" placeholder="Website or domain name">\
                    </div>\
                </div>\
            </div>';

    document.getElementById('fields').appendChild(div);

}

function removeElements(){
    
    var elements = document.getElementsByClassName('optionalElement');
    
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }
}
