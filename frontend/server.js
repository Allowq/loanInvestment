var express = require('express');
var fs = require('fs');
var dbModel = require('./data/loanInvestmentsModel');
var bodyParser = require('body-parser')
var app = express();

app.use(express.static(__dirname + '/public'));
app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
})); 

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

app.post('/register', function(req, res) {
    console.log(req.body);

    var user = new dbModel.UserModel(req.body);
    user.save(function(err) {
        if(err) console.error(error);
    });  
    res.send(JSON.stringify({"status" : "OK"}));
});

app.post('/auth', function(req, res) {
    var params = req.body;
    var resparams = {};
    console.log(params)
    dbModel.UserModel.findOne({
        "login": params.login,
        "password": params.password
    }, (err, user) => {
        if(err) {
            resparams.status = "User not found";
        } else {
            resparams.status = "OK";
            resparams.uuid = user._id;
            res.send(JSON.stringify(resparams));
        }
    });

/* dbModel.UserModel
        .where('login', params.login)
        .where('password', params.password)
        .exec(function(err, query) {
            if(err) {
                console.log(err)
                resparams.status = "User not found";
            } else {
                console.log(query)
                resparams.status = "OK";
                resparams.uuid = '123';
            }
        });*/
});


app.get('/db/users', function(req, res) {

});



app.listen(process.env.PORT || 3000, function(){
    console.log('Express server listening on port');
});