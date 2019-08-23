var events = [
  {'Date': new Date(2019, 1, 1), 'Title': 'Doctor appointment at 3:25pm.'},
  {'Date': new Date(2019, 1, 2), 'Title': 'New Garfield movie comes out!', 'Link': 'https://garfield.com'},
  {'Date': new Date(2019, 1, 5), 'Title': '25 year anniversary', 'Link': 'https://www.google.com.au/#q=anniversary+gifts'},
];
var settings = {};
var element = document.getElementById('caleandar');
caleandar(element, events, settings);
