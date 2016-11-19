var express = require('express');
var fs = require('fs');
var app = express();

app.use(express.static(__dirname + '/build'));

var filenames = [
    'tests/user.json',
    'tests/register.json',
    'tests/loans.json',
    'tests/investments.json'
]
filenames.forEach(filename => {
    app.post(`/${filename}`, function (req, res) {
        var obj = JSON.parse(fs.readFileSync(filename, 'utf8'));
        res.send(JSON.stringify(obj));
    });
})

app.listen(3001);