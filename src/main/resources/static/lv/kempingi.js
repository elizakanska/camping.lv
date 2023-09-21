// Get the template source
        var templateSource = document.getElementById("template").innerHTML;

        // Compile the template
        var template = Handlebars.compile(templateSource);

        // Get a target element where you want to insert the rendered content
        var targetElement = document.getElementById("target");

        // Fetch JSON data from Kempingi.json
        fetch("../Kempingi.json")
           .then(response => response.json())
           .then(jsonData => {
              // Loop through JSON data and render the template for each object
              jsonData.forEach(function(camping) {
                 var html = template(camping);
                 targetElement.innerHTML += html;
              });
           })
           .catch(error => {
              console.error("Error fetching JSON data:", error);
           });

// Load the handlebars-helpers library
Handlebars.registerHelper(require('handlebars-helpers')());

// Define the custom helper to iterate through images
Handlebars.registerHelper('eachImages', function(images, options) {
    let result = '';
    for (let i = 0; i < images.length; i++) {
        result += options.fn(images[i]);
    }
    return result;
});

// Define the custom helper to generate image source URLs
Handlebars.registerHelper('getImageSource', function(imageName) {
    return `../media/katalogs/ikonas/${imageName}`;
});

function loadAndNavigate(id) {
    // Fetch the JSON data and find the camping object with the matching ID
    fetch("../Kempingi.json")
        .then(response => response.json())
        .then(jsonData => {
            const selectedCamping = jsonData.find(camping => camping.ID == id);

            if (selectedCamping) {
                // Set the selected camping object to sessionStorage
                sessionStorage.setItem('selectedCamping', JSON.stringify(selectedCamping));

                // Navigate to kempings.html
                window.location.href = `kempings.html#${id}`;
            }
        })
        .catch(error => {
            console.error("Error fetching JSON data:", error);
        });
}

